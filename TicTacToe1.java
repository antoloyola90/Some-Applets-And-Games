import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe1 extends JApplet implements MouseListener {
	
	private char [][] board ;
	private boolean player1turn, winner, done;
	private char choice;
	private MyPanel canvas;
	
	public  TicTacToe1()    {
		board=new char[3][3];
	}
	
	public void init() {
		int count=49;
		for (int i=0;i<board.length;i++){
			for (int j=0;j<board[i].length;j++){
				board[i][j]=(char)count;
				count++;
			}
		}
		done = winner = false;
		player1turn = true;
		canvas = new MyPanel(); 
		setContentPane(canvas);
		canvas.setBackground(Color.lightGray);
		canvas.addMouseListener(this);
	}
	
	public void CheckForWin ( )   {
		char gamepiece = 'O';
		if ( player1turn )
			gamepiece = 'X';
		CheckForRowWin ( gamepiece );
		CheckForColWin ( gamepiece );
		CheckForDiagWin ( gamepiece );
		CheckForCatsGame ( );
	}
	
	public void CheckForRowWin ( char gamepiece )    {
		int count = 0;
		for (int i = 0; i <= 2; i++)
		{
			count = 0;
			for (int j = 0; j <= 2; j++)
				if ( board[i][j] == gamepiece )
					count++;
			if ( count == 3 )  {
				done = true;
				winner = true;
			}
		}
	}
	
	public void CheckForColWin ( char gamepiece )  {
		int count = 0;
		for (int j = 0; j <= 2; j++)
		{
			count = 0;
			for (int i = 0; i <= 2; i++)
				if ( board[i][j] == gamepiece )
					count++;
			if ( count == 3 )  {
				done = true;
				winner = true;
			}
		}
	}
	
	public void CheckForDiagWin ( char gamepiece )    {
		if ( board[0][0] == board[1][1] && board[1][1] == board[2][2] )  {
			done = true;
			winner = true;
		}
		if ( board[0][2] == board[1][1] && board[1][1] == board[2][0] )  {
			done = true;
			winner = true;
		}
	}
	
	public void CheckForCatsGame ( )    {
		int count = 0;
		for (int i = 0; i <= 2; i++)
			for (int j = 0; j <= 2; j++)
				if ( board[i][j] == 'X' || board[i][j] == 'O' )
					count++;
		if ( count == 9 )
			done = true;
	}
	
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {

            super.paintComponent(g);
            paint(g);
            //draw(g);
		}
		public void paint(Graphics g){
			int count1=0,count2=0;
			g.setColor(Color.pink);
			g.fillRect(0, 0, 400, 400);
			for(int i=0;i<board.length;i++){
				for (int j=0;j<board[i].length;j++){
					if(j%2==0&&i%2==0){
						g.setColor(Color.green);
						g.fillRect(i*50,j*50,50,50);
					}
					if(j%2==1&&i%2==1){
						g.setColor(Color.green);
						g.fillRect(i*50,j*50,50,50);
					}
				}
			}
			for(int i=0;i<board.length;i++){
				for (int j=0;j<board[i].length;j++){
					if(board[i][j]=='X')
						count1++;
					if(board[i][j]=='O')
						count2++; 
				}
			}

			for(int i=0;i<board.length;i++){
				for (int j=0;j<board[i].length;j++){
					if(board[i][j]=='X'){
						g.setColor(Color.red);
						g.fillOval(50*j,50*i,50,50);
						g.setColor(Color.black);
						g.drawLine(50*j+3,50*i+15,50*j+46,50*i+15);
						g.drawLine(50*j+46,50*i+15,50*j+7,50*i+42);
						g.drawLine(50*j+7,50*i+42,50*j+25,50*i);
						g.drawLine(50*j+25,50*i,50*j+42,50*i+42);
						g.drawLine(50*j+42,50*i+42,50*j+3,50*i+15);
					}
					if(board[i][j]=='O'){
						g.setColor(Color.blue);
						g.fillOval(50*j,50*i,50,50);
						g.setColor(Color.black);
						g.drawArc(50*j+5,50*i+8,10,10,180,20);
					}
					
				}
			}
			if (winner && !player1turn){
				g.drawString("Red is the winner!",100,200);
			}
			if (winner && player1turn){
				g.drawString("Blue is the winner!",100,200);
			}
			/*if (winner){
				g.drawString("CATS GAME FOR YOU & U & U!!!!  HA HA HA :-)",100,200);
			}*/
		
		}
	} 
	
	public void mouseClicked ( MouseEvent e )   {}
	
	public void mousePressed ( MouseEvent e )    {
		int x=e.getX();
		int y=e.getY();
		
		if(x>=0 && x<=150 &&y>=0 && y<=150 && !done){
			int row=y/50;
			int col=x/50;
			if( board [row][col] != 'X' || board [row][col] != 'O' ){
				
				if ( player1turn )
					board [row][col] = 'X';
				else
					board [row][col] = 'O';
				CheckForWin ( );
				player1turn = !player1turn;
				canvas.repaint();	
			}
		}
		
	}
	
	public void mouseReleased ( MouseEvent e )   {}
	
	public void mouseEntered ( MouseEvent e )   {}
	
	public void mouseExited ( MouseEvent e )     {}
}









