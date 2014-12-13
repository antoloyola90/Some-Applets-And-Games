public class Connect4 {
	private TextReader console = new TextReader();
	private int c;
	private char[][] board = new char[5][5]; //  The 5x5 gameboard.
	private boolean player1turn; //  Toggles back and forth between players.
	private int columnchoice; //  The column number chosen by the player.
	
	public Connect4() { //  Sets up the variables so that player 1
		player1turn = true; //  starts first, and the board is filled
		columnchoice = 0; //  with spaces.
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = ' ';
	}
	
	public static void main(String[] args) {
		Connect4 play = new Connect4();
		play.Game();
		
	}
	
	public void Game() {
		do {
			ShowBoard(); //  Displays the board.
			AskForMove(); //  Prompts the user to enter a column number,
			//  and error check the value entered.
			PlaceXorO(); //  Place the gamepiece in the proper column,
			//  and the proper row.
		} while (!Winner() && !CatsGame()); //  Loops back for the next turn if
		// there is
		//  not yet a winner, and the game board is not
		//  yet full (cat's game).
		ShowBoard(); //  Shows the board one last time.
		PrintEndMessage(); //  A message telling the winner or cat's game.
	}
	
	public void ShowBoard() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++)
				System.out.print("----");
			System.out.println();
			for (int j = 1; j <= 6; j++) {
				System.out.print("| ");
				if (j < 6)
					System.out.print(board[i - 1][j - 1]);
				else
					System.out.print(' ');
				System.out.print(' ');
			}
			System.out.println();
		}
		for (int j = 1; j <= 5; j++)
			System.out.print("----");
	}
	
	public int GetNumber(String message) {
		
		while (true) {
			System.out.print(message);
			String c = console.readLine();
			if (c != null && c.length() == 1) {
				char ch = c.charAt(0);
				if (ch >= '1' && ch <= '5')
					return ch - '0';
			}
			
		}
		
	}
	
	public void AskForMove() {
		
		if (player1turn == true) {
			c = GetNumber("Player 1, it is your turn.\nEnter the column number where you would like to place an X -> ");
		}
		if (player1turn == false) {
			c = GetNumber("Player 2, it is your turn.\nEnter the column number where you would like to place an O -> ");
		}
	}
	
	public void PlaceXorO() {
		boolean nomove = true;
		while (nomove) {
			for (int i = 4; nomove && i >= 0; i--) {
				if (board[i][c - 1] == ' ') {
					if (player1turn)
						board[i][c - 1] = 'X';
					else
						board[i][c - 1] = 'O';
					player1turn = !player1turn;
					nomove = false;
				}
			}
			if (nomove)
				AskForMove();
		}
	}
	
	public boolean CatsGame() {
		for (int j = 0; j < 5; j++)
			if (board[0][j] == ' ')
				return false;
		return true;
	}
	
	public void PrintEndMessage() {
		if (Winner() && !player1turn)
			System.out.print("Player 1 is the WINNER!!!!!");
		if (Winner() && player1turn)
			System.out.print("Player 2 is the WINNER!!!!!");
		if (CatsGame())
			System.out.print("CATS GAME FOR YOU & U & U!!!!  HA HA HA :-)\n\n");
	}
	
	public boolean Winner() {
		boolean roworcolwin = checkForRowOrColWin();
		boolean diagwin = checkForDiagWin();
		if (roworcolwin || diagwin)
			return true;
		return false;
	}
	
	public boolean checkForRowOrColWin() {
		int rowcount = 0, colcount = 0;
		for (int shift = 0; shift < 2; shift++) {
			for (int i = 0; i < board.length; i++) {
				rowcount = 0;
				colcount = 0;
				for (int j = 0; j < board[i].length - 2; j++) {
					if (board[i][shift + j] == board[i][shift + j + 1]
														&& board[i][shift + j] != ' ')
						rowcount++;
					if (board[shift + j][i] == board[shift + j + 1][i]
																	&& board[shift + j][i] != ' ')
						colcount++;
				}
				if (rowcount == 3 || colcount == 3)
					return true;
			}
		}
		return false;
	}
	
	public boolean checkForDiagWin() {
		int diagupcount = 0, diagdowncount = 0;
		for (int shift1 = 0; shift1 < 2; shift1++) {
			for (int shift2 = 0; shift2 < 2; shift2++) {
				diagupcount = 0;
				diagdowncount = 0;
				for (int j = 0; j < 3; j++) {
					if (board[shift1 + j][shift2 + j] == board[shift1 + j + 1][shift2
																			   + j + 1]
																			   && board[shift1 + j][shift2 + j] != ' ')
						diagdowncount++;
					if (board[4 - (shift1 + j)][shift2 + j] == board[4 - (shift1
							+ j + 1)][shift2 + j + 1]
									  && board[4 - (shift1 + j)][shift2 + j] != ' ')
						diagupcount++;
				}
				if (diagupcount == 3 || diagdowncount == 3)
					return true;
			}
		}
		return false;
	}

}

