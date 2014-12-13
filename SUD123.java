
import java.io.*;
import com.cisco.util.Helper;
public class Sudoku {
	
	public static void setBoard(int lengthOfEachBox) {
		len=lengthOfEachBox;
		size=len*len;
	}
	
	public static int getBoardSize() {
		return size;
	}	
	
	public static int set(int row, int col, int val) {  // 0<=row<=size, 0<=col<=size
		setVal(row, col, val, true);
		if (get(row, col)!=val)
			return -1;
		else
			return val;
	}
	
	public static int get(int row, int col) {  // 0<=row<=size, 0<=col<=size
		return getVal(row, col);
	}
	
	public static boolean isUserSet(int row, int col) {  // 0<=row<=size, 0<=col<=size
		return getX3(row, col).isUserSet(row%len, col%len);
	}
	
	// repeat this method until false
	public static boolean arrangeNext() {
		ThreeX3 x3=board[myr][myc];
		myc++;
		if (myc>=len) {
			myc=0;
			myr++;
		}
		if (myr>=len) {
			myr=0;
			myc=0;
		}
		return shuffle(x3);
	}
	
	public static void fillBoard() {
		for (int row=0;row<len;row++) 
			for (int col=0;col<len;col++)	{
				ThreeX3 x3=board[row][col];
				x3.fill();
			}
	}
	
	/////////////////////////////////////////
	
	static int len=2;
	static int size=len*len;
	private static ThreeX3[][] board=new ThreeX3[len][len];
	private static int myr=0, myc=0;
	static {
		for (int i=0;i<len;i++)
			for (int j=0;j<len;j++)
				board[i][j]=new ThreeX3(i*len+j);
	};
	
	

	static void p(Object o) {
		System.out.print(o);
	}
	static void p(String format, Object...o) {
		System.out.printf(format, o);
	}
	static void nl() {
		System.out.println();
	}
	
	static void setVal(int row, int col, int val) {  // 0<=row<=size, 0<=col<=size
		setVal(row, col, val, false);
	}
	static void setVal(int row, int col, int val, boolean userset) {  // 0<=row<=size, 0<=col<=size
		ThreeX3 x3=getX3(row, col);
		x3.set(row%len, col%len, val, userset);
	}
	static int getVal(int row, int col) {  // 0<=row<=size, 0<=col<=size
		ThreeX3 x3=getX3(row, col);
		return x3.get(row%len, col%len);
	}
	static ThreeX3 getX3(int row, int col) {  // 0<=row<=size, 0<=col<=size
		return board[row/len][col/len]; 
	}
	
	
	static void shuffleBoard() {
		boolean changed=true;
		while (changed) {
			boolean chg=false;
			for (int r=0;r<len;r++) {
				for (int c=0;c<len;c++) {
					ThreeX3 x3=board[r][c];
					chg|=shuffle(x3);
				}
			}
			changed=chg;
		}
	}	
	
	static boolean shuffle(ThreeX3 x3) {
		boolean changed=false;
		
		for (int r=0;r<len;r++) {
			for (int c=0;c<len;c++) {
				if (!x3.isUserSet(r,c)) {
					changed|=swap(r, c, x3);
				}
			}
		}
		return changed;
	}
	
	static int conflictRow(int r, int c, ThreeX3 x3) { //conflict at row r in column
		int n=x3.get(r,c);
		int row=r+len*(x3.block()/len);
		for (int i=0;i<size;i++) {
			ThreeX3 nx3=getX3(row, i);
			if (x3!=nx3) {
				int nn=getVal(row, i);
				if (nn==n) {
					return i;
				}
			}
		}
		return -1;
	}
	
	static int conflictCol(int r, int c, ThreeX3 x3) { //conflict at col c in row
		int n=x3.get(r,c);
		int col=c+len*(x3.block()%len);
		for (int i=0;i<size;i++) {
			ThreeX3 nx3=getX3(i, col);
			if (x3!=nx3) {
				int nn=getVal(i, col);
				if (nn==n) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	static boolean swap(int r, int c, ThreeX3 x3) {
		for (int i=0;i<len;i++) {
			for (int j=0;j<len;j++) {
				if (x3.get(r,c)!=x3.get(i,j) && !x3.isUserSet(i,j)) {
					x3.swap(r,c,i,j); //no need to swap unless conflict???
					int confl=conflictRow(i, j, x3);
					if (confl<0)
						confl=conflictCol(i, j, x3);
					if (confl>=0)
						x3.swap(i,j,r,c);
					else
						return true;
				}
			}
		}
		return false;
	}
	
	static ThreeX3 get(int bl) {
		return board[bl/len][bl%len];
	}
	
	static void printBoard() {
		p("-------------------------------------------------\n");
		int rsum[]=new int[size];
		for (int row=0;row<len;row++) { 
			for (int r=0;r<len;r++)	{
				int sum=0;
				for (int col=0;col<len;col++) {
					ThreeX3 x3=board[row][col];
					for (int c=0;c<len;c++) {
						sum+=x3.get(r,c);
						rsum[col*len+c]+=x3.get(r,c);
						if (x3.isUserSet(r,c))
							p("{%d}\t", x3.get(r,c));
						else
							p("%d\t", x3.get(r,c));
					}
				}
				p(" = %5d", sum);
				nl();
			}
			nl();
		}
		for (int i:rsum)
			p("=\t");
		nl();
		for (int i:rsum)
			p("%2d\t", i);
		nl();
		p("===================================================\n");
	}
}

class ThreeX3 {
	static int len=Sudoku.len;
	static int size=Sudoku.size;
	
	private int block=0;
	private int[][] X3=new int[len][len];
	private int[][] userSet=new int[len][len];
	
	ThreeX3(int bl) {
		block=bl;
	}
	void set(int r, int c, int val) {
		set(r,c,val,false);
	}
	void set(int r, int c, int val, boolean userset) {
		if (isSet(val))
			return;
		X3[r][c]=val;
		if (userset)
			userSet[r][c]=val;
	}
	boolean isSet(int val) {
		for (int i=0;i<len;i++)
			for (int j=0;j<len;j++)
				if (X3[i][j]==val)
					return true;
		return false;
	}
	void swap(int r1, int c1, int r2, int c2) {
		int t=X3[r1][c1];
		X3[r1][c1]=X3[r2][c2];
		X3[r2][c2]=t;
	}
	
	int get(int r, int c) {
		return X3[r][c];
	}
	int block() {
		return block;
	}
	boolean isUserSet(int r, int c) {
		return userSet[r][c]>0;
	}
	void fill() {
		int cnt=1;
		for (int i=0;i<len;i++) {
			for (int j=0;j<len;j++) {
				if (!isUserSet(i,j)) {
					while (isSet(cnt))
						++cnt;
					X3[i][j]=cnt;
				}
			}
		}
	}
	void printBoard() {
		Sudoku.p("Block=%d%n", block);
		for (int r=0;r<len;r++)	{
			for (int c=0;c<len;c++) {
				if (isUserSet(r,c))
					Sudoku.p("{%d,%d}\t", X3[r][c], userSet[r][c]);
				else
					Sudoku.p("%d\t", X3[r][c]);
			}
			Sudoku.nl();
		}
		Sudoku.nl();
	}
}

class MainSudoku extends Sudoku {

	static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
	static void readBoard(int row) throws Exception {
		p("Row#%d\t", row+1);
		for (int i=1;i<=size;i++)
			p("%d\t", i);
		nl();
		p("\t");
		String s=reader.readLine();
		String[]t=Helper.tokenize(s, "\t", false);
		int i=0;
		for (String ss:t) {
			if (ss.length()>0)
				setVal(row, i, Integer.parseInt(ss), true);
			i++;
		}
	}
	
	static void setRow(int row) throws Exception {
		p("Row#%d-->", row+1);
		String s=reader.readLine();
		String[]t=Helper.tokenize(s, "\t ", false);
		for (int i=0;i<t.length;i++) {
			int v=Integer.parseInt(t[i])-1;
			setVal(row, v, getVal(row, v), true);
		}
	}
	
	public static void main(String[] args) throws Exception {
		for (int row=0;row<size;row++) readBoard(row);
		fillBoard();
		printBoard();
		//for (int row=0;row<size;row++) setRow(row);
		//printBoard();
		//shuffleBoard();
		while (arrangeNext()) printBoard();
		printBoard();
	}
}