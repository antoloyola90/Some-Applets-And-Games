
import java.io.*;
import java.util.*;

public class Sudoku implements Serializable {
	
	private Sudoku(int boardLen) {
		size=boardLen;
		len=(int)Math.sqrt(size);
		
		board=new ThreeX3[len][len];		
		for (int i=0;i<len;i++)
			for (int j=0;j<len;j++)
				board[i][j]=new ThreeX3(i*len+j, len);
	}
	
	public  int getBoardSize() {
		return size;
	}
	
	public  int getCubeSize() {
		return len;
	}	
	
	public  int set(int row, int col, int val) {  // 0<=row<=size, 0<=col<=size
		setVal(row, col, val, true);
		if (get(row, col)!=val)
			return -1;
		else
			return val;
	}
	
	public  int get(int row, int col) {  // 0<=row<=size, 0<=col<=size
		return getVal(row, col);
	}
	
	public  boolean isUserSet(int row, int col) {  // 0<=row<=size, 0<=col<=size
		return getX3(row, col).isUserSet(row%len, col%len);
	}
	
	// repeat this method until false
	private int num1, num2;
	private boolean goCol=false;
	public synchronized boolean arrangeNext() {
		num1=randomg.nextInt(101)%len;//goCol?myc:myr;
		num2=randomg.nextInt(101)%len;//goCol?myr:myc;
		ThreeX3 x3=board[num1][num2];
		myc++;
		if (myc>=len) {
			myc=0;
			myr++;
		}
		if (myr>=len) {
			myr=0;
			myc=0;
			goCol=!goCol;
		}
		boolean b=shuffle(x3);
		if (myr==0&&myc==0)
			return b;
		return true;
	}
	
	public static Sudoku readBoard(File file) throws Exception {
		FileInputStream fis=new FileInputStream(file);
		BufferedReader reader=new BufferedReader(new InputStreamReader(fis));
		String s=reader.readLine();
		String[]t=tokenize(s, "\t ", false);
		Sudoku su=new Sudoku(t.length);
		int row=0;
		do {
			int col=0;
			for (String ss:t) {
				int val=Integer.parseInt(ss);
				if (val>0)
					su.setVal(row, col, val, true);
				col++;
			}
			row++;
			if (row<su.size) {
			s=reader.readLine();
			t=tokenize(s, "\t ", false);
			}
		} while (row<su.size);
		return su;
	}
	
	
	/////////////////////////////////////////
	
	private int len;
	private int size;
	private  ThreeX3[][] board=null;
	private  int myr=0, myc=0;

	static void p(Object o) {
		System.out.print(o);
	}
	static void p(String format, Object...o) {
		System.out.printf(format, o);
	}
	static void nl() {
		System.out.println();
	}
	
	public static String[] tokenize(String s, String delim, boolean keepBlank) {
		List<String> v=new ArrayList<String>();
		StringTokenizer st;

		if (delim==null)
			st=new StringTokenizer(s);
		else
			st=new StringTokenizer(s, delim);

		while (st.hasMoreTokens()) {
			String tok=st.nextToken();
			if (keepBlank)
				v.add(tok);
			else {
				tok=tok.trim();
				if (!tok.equals(""))
					v.add(tok);
			}
		}
		return v.toArray(new String[]{});
		
	}

	
	
	 void setVal(int row, int col, int val) {  // 0<=row<=size, 0<=col<=size
		setVal(row, col, val, false);
	}
	 void setVal(int row, int col, int val, boolean userset) {  // 0<=row<=size, 0<=col<=size
		ThreeX3 x3=getX3(row, col);
		x3.set(row%len, col%len, val, userset);
	}
	 int getVal(int row, int col) {  // 0<=row<=size, 0<=col<=size
		ThreeX3 x3=getX3(row, col);
		return x3.get(row%len, col%len);
	}
	 ThreeX3 getX3(int row, int col) {  // 0<=row<=size, 0<=col<=size
		return board[row/len][col/len]; 
	}

	 void shuffleBoard() {
		boolean changed=true;
		while (changed) {
			boolean chg=false;
			for (int r=0;r<len;r++) {
				for (int c=0;c<len;c++) {
					ThreeX3 x3=board[r][c];
					if (conflictRow(r,c, x3)>=0)
						chg|=shuffle(x3);
					else if (conflictCol(r,c, x3)>=0)
						chg|=shuffle(x3);
				}
			}
			changed=chg;
		}
	}	
	
	 boolean shuffle(ThreeX3 x3) {
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
	
	 int conflictRow(int r, int c, ThreeX3 x3) { //conflict at row r in column
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
	
	 int conflictCol(int r, int c, ThreeX3 x3) { //conflict at col c in row
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
	
	
	 boolean swapSelf(int r, int c, ThreeX3 x3) {
		for (int i=0;i<len;i++) {
			for (int j=0;j<len;j++) {
				if (x3.get(r,c)!=x3.get(i,j)&&!x3.isUserSet(i,j)&&!x3.isUserSet(r, c)) {
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
	
	boolean swap(int r, int c, ThreeX3 x3) {
		boolean b, chg=false;
		int confl=conflictRow(r, c, x3);
		
		int row=r+len*(x3.block()/len);
		int col=c+len*(x3.block()%len);
		
		if (confl>=0) {
			ThreeX3 nx3=getX3(row, confl);
			chg|=b=swapSelf(r, confl%len, nx3);
			if (!b)
				swapSelf(r, c, x3);
		}
		confl=conflictCol(r, c, x3);
		if (confl>=0) {
			ThreeX3 nx3=getX3(confl, col);
			chg|=b=swapSelf(confl/len, c, nx3);
			if (!b)
				swapSelf(r, c, x3);
		}
		return chg;
	}
	 
	 
	 ThreeX3 get(int bl) {
		return board[bl/len][bl%len];
	}
	
	 void printBoard() {
		p("-------------------------------------------------\n");
		int rsum[]=new int[size];

		for (int r=0;r<size;r++) {
			int sum=0;
			for (int c=0;c<size;c++) {
				int g=get(r,c);
				sum+=g;
				rsum[c]+=g;
				if (isUserSet(r,c))
					p("{%d}\t", g);
				else
					p("%d\t", g);
			}
			p(" = %5d", sum);
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

class ThreeX3 implements Serializable {
	int len;
	private int block=0;
	private int[][] X3;
	private int[][] userSet;
	int count=1;
	
	ThreeX3(int bl, int len) {
		block=bl;
		this.len=len;
		X3=new int[len][len];
		userSet=new int[len][len];
	}
	void set(int r, int c, int val) {
		set(r,c,val,false);
	}
	void set(int r, int c, int val, boolean userset) {
		if (isSet(val))
			return;
		X3[r][c]=val;
		if (val==0)
			userSet[r][c]=0;
		else if (userset)
			userSet[r][c]=val;
	}
	boolean isSet(int val) {
		for (int i=0;i<len;i++)
			for (int j=0;j<len;j++)
				if (X3[i][j]!=0 && X3[i][j]==val)
					return true;
		return false;
	}
	private void reset() {
		for (int i=0;i<len;i++)
			for (int j=0;j<len;j++)
				if (!isUserSet(i,j))
					X3[i][j]=0;
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
	void fill(boolean random, Random randg) {
		/*
		reset();
		int cnt=1;
		for (int i=0;i<len;i++) {
			for (int j=0;j<len;j++) {
				if (X3[i][j]==0) {
					int g=random?randg.nextInt(len*len)+1:cnt;
					while (isSet(g))
						g=random?randg.nextInt(len*len)+1:++cnt;
					X3[i][j]=g;
				}
			}
		}
		*/
		if (!random) {
			reset();
			count=1;
			int cnt=1;
			for (int i=0;i<len;i++) {
				for (int j=0;j<len;j++) {
					if (X3[i][j]==0) {
						while (isSet(cnt))
							++cnt;
						X3[i][j]=cnt;
					}
				}
			}
		}
		else {
			int sz=len*len;
			int cnt=++count%sz+1;
			reset();
			for (int i=0;i<len;i++) {
				for (int j=0;j<len;j++) {
					if (!isUserSet(i,j)) {
						while (isSet(cnt))
							cnt=(cnt+1)%sz+1;
						X3[i][j]=cnt;
					}
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

class MainSudoku {
	
	static Sudoku su;
	
	public static final void main(String[] args) throws Exception {
		su=Sudoku.readBoard(new File(args[0]));
		su.printBoard();
		//shuffleBoard();
		while (su.arrangeNext()) su.printBoard();
		su.printBoard();
	}
}

