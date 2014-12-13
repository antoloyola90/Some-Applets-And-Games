public class TicTacToe {
	private int size=3, number,j,m;
	private char[][] board=new char[3][3];
	private char turn, letter;
	private boolean done=false;
	private boolean [][] taken=new boolean[3][3];
	
	public TicTacToe() {
		for (int i=0;i<size;i++)
			for (int j=0;j<size;j++)
				board[i][j]=(char)(i*size+j+'a');
	}
	
	public void printBoard() {
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TicTacToe t=new TicTacToe();
		t.GetInfo();
		t.PrintInfo();
	}
	public void GetInfo()	{
		TextReader key=new TextReader();
		do {	
			System.out.print("Enter 'p' if you want to go first or 'c' for the computer to go first  ->");
			turn=key.readlnChar();
			System.out.println();
		} while(turn!='c' && turn!='p');
		while (!done) {
			if (turn=='c')
				Cturn();
			else if (turn=='p'){
				printBoard();
				do{
				System.out.print("Enter the letter for your move  ->");
				letter=key.readlnChar();
				j=letter-'a';
				m=j/3;
				}while(taken[letter][m]);
				Pturn();
				printBoard();
				Cturn();
				printBoard();
			}
		}
	}
	
	public void Cturn() {
		int r=number/size;
		int cnt=0;
		for (int i=0;i<size;i++)
			if (board[r][i]=='P') cnt++;
		if (cnt>=size-1) {
			for (int i=0;i<size;i++) {
				if (board[r][i]!='P' && board[r][i]!='C') {
					board[r][i]='C'; return;
				}
			}
		}
		
		int c=number%size;
		cnt=0;
		for (int i=0;i<size;i++)
			if (board[i][c]=='P') cnt++;
		if (cnt>=size-1) {
			for (int i=0;i<size;i++) {
				if (board[i][c]!='P' && board[i][c]!='C') {
					board[i][c]='C'; return;
				}
			}
		}
		
		cnt=0;
		for (int i=0;i<size;i++)
			if (board[i][i]=='P') cnt++;
		if (cnt>=size-1) {
			for (int i=0;i<size;i++) {
				if (board[i][i]!='P' && board[i][i]!='C') {
					board[i][i]='C'; return;
				}
			}
		}
		
		cnt=0;
		for (int i=0;i<size;i++)
			if (board[i][size-i-1]=='P') cnt++;
		if (cnt>=size-1) {
			for (int i=0;i<size;i++) {
				if (board[i][size-i-1]!='P' && board[i][size-i-1]!='C') {
					board[i][size-i-1]='C'; return;
				}
			}
		}

		for (int i=0;i<size;i++) {
			if (board[i][i]!='P' && board[i][i]!='C') {
				board[i][i]='C'; return;
			}
		}
		
		for (int i=0;i<size;i++) {
			if (board[i][size-i-1]!='P' && board[i][size-i-1]!='C') {
				board[i][size-i-1]='C'; return;
			}
		}
		
		for (int i=0;i<size;i++) {
			if (board[r][i]!='P' && board[r][i]!='C') {
				board[r][i]='C'; return;
			}
		}
		
	}
	
	public void Pturn() {	
		number=letter-'a';
		board[number/size][number%size]='P';
	}
	
	public void PrintInfo()	{
	}
}
