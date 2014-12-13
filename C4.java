//Anto Loyola
//Period 4
//This program plays the game of connect4 in an applet and as you click into a row it advances to the lowest untaken spot.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class C4  extends JApplet implements MouseListener{
	private MyPanel canvas;
	private TextReader console = new TextReader();
	private int c,s,t;
	private char[][] play = new char[5][5]; //  The 5x5 gameboard.
	private boolean player,done,winner,bob; //  Toggles back and forth between players.
	private int columnchoice; //  The column number chosen by the player.
	private boolean [][] taken ;
	
	public C4() { //  Sets up the variables so that player 1
		player=done = true; //  starts first, and the board is filled
		bob=true;
		columnchoice = 0; //  with spaces.
		taken=new boolean[5][5];
		for (int i = 0; i < play.length; i++)
			for (int j = 0; j < play[i].length; j++)
				play[i][j] = ' ';
		for (int i=0;i<play.length;i++)
			for (int j=0;j<play[i].length;j++)
				taken[i][j]=false;
	}
	
	public static void main(String[] args) {
		C4 play = new C4();
		//play.Game();
		
	}
	public boolean CatsGame() {
		for (int j = 0; j < 5; j++)
			if (play[0][j] == ' ')
				return false;
		return true;
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
			for (int i = 0; i < play.length; i++) {
				rowcount = 0;
				colcount = 0;
				for (int j = 0; j < play[i].length - 2; j++) {
					if (play[i][shift + j] == play[i][shift + j + 1]
													  && play[i][shift + j] != ' ')
						rowcount++;
					if (play[shift + j][i] == play[shift + j + 1][i]
																  && play[shift + j][i] != ' ')
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
					if (play[shift1 + j][shift2 + j] == play[shift1 + j + 1][shift2
																			 + j + 1]
																			 && play[shift1 + j][shift2 + j] != ' ')
						diagdowncount++;
					if (play[4 - (shift1 + j)][shift2 + j] == play[4 - (shift1
							+ j + 1)][shift2 + j + 1]
									  && play[4 - (shift1 + j)][shift2 + j] != ' ')
						diagupcount++;
				}
				if (diagupcount == 3 || diagdowncount == 3)
					return true;
			}
		}
		return false;
	}
	
	
	
	public void init() {
		int count=49;
		for (int i=0;i<play.length;i++){
			for (int j=0;j<play[i].length;j++){
				play[i][j]=' ';
				count++;
			}
		}
		done = winner = false;
		player = true;
		canvas = new MyPanel(); 
		setContentPane(canvas);
		canvas.setBackground(Color.lightGray);
		canvas.addMouseListener(this);

	}
	
	class MyPanel extends JPanel {
		
		public void paint(Graphics g){
			if(bob==true){
				int count1=0,count2=0;
				Color y=Color.getHSBColor( (float)Math.random(), 0.4F, 0.4F );
				g.setColor(y);
				//g.setColor(Color.pink);
				g.fillRect(0, 0, 500, 600);
				for(int i=0;i<play.length;i++){
					for (int j=0;j<play[i].length;j++){
						if(j%2==0&&i%2==0){
							//Color m=Color.getHSBColor( (float)Math.random(), 0.6F, 0.6F );
							//g.setColor(m);
							g.setColor(Color.green);
							g.fillRect(i*100,j*100,100,100);
						}
						if(j%2==1&&i%2==1){
							//Color m=Color.getHSBColor( (float)Math.random(), 0.6F, 0.6F );
							//g.setColor(m);
							g.setColor(Color.yellow);
							g.fillRect(i*100,j*100,100,100);
						}
					}
				}
				for(int i=0;i<play.length;i++){
					for (int j=0;j<play[i].length;j++){
						if(play[i][j]=='X'){
							g.setColor(Color.red);
							
						}
						else if(play[i][j]=='O'){
							g.setColor(Color.blue);
						}
						if(play[i][j]=='X'||play[i][j]=='O') {
							g.fillOval(100*j,100*i,100,100);
							g.setColor(Color.black);
							g.drawLine(100*j+3,100*i+15,100*j+46,100*i+15);
							g.drawLine(100*j+46,100*i+15,100*j+7,100*i+42);
							g.drawLine(100*j+7,100*i+42,100*j+25,100*i);
							g.drawLine(100*j+25,100*i,100*j+42,100*i+42);
							g.drawLine(100*j+42,100*i+42,100*j+3,100*i+15);
						}
						
					}
					
				}
				g.setFont(new Font("serif",Font.BOLD,40));
				Color z=Color.getHSBColor( (float)Math.random(), 0.9F, 0.9F );
				g.setColor(z);
				if (Winner() && !player){
					g.drawString("Red is the winner!",220,550);
					bob=false;
				}
				if (Winner() && player){
					g.drawString("Blue is the winner!",220,550);
					bob=false;
				}
				if (CatsGame()){
					g.drawString("CATS GAME FOR YOU & U & U!!!!  HA HA HA :-)",220,550);
					bob=false;
				}
			}
		}
	} 
	
	public void mouseClicked ( MouseEvent e )   {}
	
	public void mousePressed ( MouseEvent e )    {
		if ( e.isShiftDown() ) {
			player=true;
			bob=true;
			for (int i=0;i<play.length;i++){
				for (int j=0;j<play[i].length;j++){
					taken[i][j]=false;
					play[i][j]= ' ';
				}
			}
			repaint();
			return;
		}
		
		int x=e.getX();
		int y=e.getY();
		
		if(x>=0 && x<=500 &&y>=0 && y<=500){
			int row=y/100;
			int col=x/100;
			if(taken[row][col]==false){
				
				if( play [row][col] != 'X' || play [row][col] != 'O' ) {
					char c;
					if ( player )
						c='X';
					else
						c='O';
					int sro=row; 
					for (int i=row+1;i<play.length;i++) {
						if (taken[i][col]==false)
							sro=i;
						else
							break;
					}
					row=sro;
					play[row][col]=c;
					taken[row][col]=true;
					player = !player;
					repaint();
					Winner ( );
				}
			}
		}
	}
	

	
	public void mouseReleased ( MouseEvent e )   {}
	
	public void mouseEntered ( MouseEvent e )   {}
	
	public void mouseExited ( MouseEvent e )     {}
}









