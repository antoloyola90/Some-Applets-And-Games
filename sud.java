//	Anto Loyola		4/4/05
//	Tile.java
//	This program allows you to navigate through a tile field and as you press enter it will change the color you are on by two, the ones 
//	immediately around you by two and the ones completely around you by 1, then you  press enter to start all over again!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class sud extends JApplet implements KeyListener, 
FocusListener, MouseListener   {
	private int [][]board;
	private int x=0,y=0,num=0;
	private Color[]colors=new Color[]{Color.white,Color.red,Color.blue,
			Color.green,Color.yellow,Color.pink,Color.black, Color.CYAN, Color.MAGENTA};
	private boolean firsttime=true;
	
	
	public sud ( )   {
		clear();
	}
	
	public void clear ( )   {
		board = new int[12][12];
		for ( int i = 0; i < 12; i++ )   {
			for ( int j = 0; j < 12; j++ ) { 
				board[i][j]=0;
			}
		}
		x=(int)(Math.random()*12);
		y=(int)(Math.random()*12);
		
	}
	
	public void init ()  { 
		
		setBackground(Color.gray);
		addFocusListener(this);
		addKeyListener(this);
		addMouseListener(this);
	}
	
	
	class MyPanel extends JPanel {

		/*public void paint(Graphics g) {
			g.setColor(colors[0]);
			g.fillRect(0*90, 0*90, 90, 90);g.setColor(colors[1]);
			g.fillRect(1*90, 0*90, 90, 90);g.setColor(colors[2]);
			g.fillRect(2*90, 0*90, 90, 90);g.setColor(colors[3]);
			g.fillRect(0*90, 1*90, 90, 90);g.setColor(colors[4]);
			g.fillRect(1*90, 1*90, 90, 90);g.setColor(colors[5]);
			g.fillRect(2*90, 1*90, 90, 90);g.setColor(colors[6]);
			g.fillRect(0*90, 2*90, 90, 90);g.setColor(colors[7]);
			g.fillRect(1*90, 2*90, 90, 90);g.setColor(colors[8]);
			g.fillRect(2*90, 2*90, 90, 90);
			
			g.setColor(Color.lightGray);
			g.fillRect(3*90, 3*90, 90, 90);
			g.setColor(Color.BLACK);
			g.drawString("1", 284, 284);
			g.drawString("2", 314, 284);
			g.drawString("3", 344, 284);
			g.drawString("4", 284, 314);
			g.drawString("5", 314, 314);
			g.drawString("6", 344, 314);
			g.drawString("7", 284, 344);
			g.drawString("8", 314, 344);
			g.drawString("9", 344, 344);
			
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 12; j++) {
					g.setColor(Color.white);
					g.drawLine(i * 30, 0, i * 30, 400);
					g.drawLine(i * 30 + 1, 0, i * 30 + 1, 400);
					g.drawLine(0, j * 30, 400, j * 30);
					g.drawLine(0, j * 30 + 1, 400, j * 30 + 1);
				}
			}
			
		
		}
		
	}*/
	
	
	
	
	public void paint(Graphics g) {
		
		g.setColor(colors[0]);
		g.fillRect(0*90, 0*90, 90, 90);g.setColor(colors[1]);
		g.fillRect(1*90, 0*90, 90, 90);g.setColor(colors[2]);
		g.fillRect(2*90, 0*90, 90, 90);g.setColor(colors[3]);
		g.fillRect(0*90, 1*90, 90, 90);g.setColor(colors[4]);
		g.fillRect(1*90, 1*90, 90, 90);g.setColor(colors[5]);
		g.fillRect(2*90, 1*90, 90, 90);g.setColor(colors[6]);
		g.fillRect(0*90, 2*90, 90, 90);g.setColor(colors[7]);
		g.fillRect(1*90, 2*90, 90, 90);g.setColor(colors[8]);
		g.fillRect(2*90, 2*90, 90, 90);
		
		g.setColor(Color.lightGray);
		g.fillRect(3*90, 3*90, 90, 90);
		g.setColor(Color.BLACK);
		g.drawString("1", 284, 284);
		g.drawString("2", 314, 284);
		g.drawString("3", 344, 284);
		g.drawString("4", 284, 314);
		g.drawString("5", 314, 314);
		g.drawString("6", 344, 314);
		g.drawString("7", 284, 344);
		g.drawString("8", 314, 344);
		g.drawString("9", 344, 344);
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				g.setColor(Color.white);
				g.drawLine(i * 30, 0, i * 30, 400);
				g.drawLine(i * 30 + 1, 0, i * 30 + 1, 400);
				g.drawLine(0, j * 30, 400, j * 30);
				g.drawLine(0, j * 30 + 1, 400, j * 30 + 1);
			}
		}
		
		
		
		
		
		
		
		
		/*if ( firsttime )   {
			GiveDirections ( g );
			
		}
		else   {
			for ( int i = 0; i < 12; i++ )   
				for ( int k = 0; k < 12; k++ ) {  
					g.drawLine(k*30,0,k*30,300);
					g.drawLine(0,i*30,300,i*30);
				}
			for ( int i = 0; i < 12; i++ )  { 
				for ( int k = 0; k < 12; k++ ) { 
					int b=board[i][k];
					g.setColor(colors[b]);
					g.fillRect(i*30+1,k*30+1,30,30);
					
				}
			}
			
			g.setColor(Color.lightGray);
			g.fillRect(x*30+1,y*30+1,30,30);
		}*/
		
		
	}}
	
	public void focusGained(FocusEvent evt) {
		firsttime = false;
		repaint();
	}
	
	public void focusLost(FocusEvent evt) {
		firsttime = true;
		repaint();
	}
	
	public void mousePressed(MouseEvent evt) {
		requestFocus();
	}   
	
	public void mouseEntered(MouseEvent evt) { }
	public void mouseExited(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }
	public void mouseClicked(MouseEvent evt) { }
	
	public void keyTyped ( KeyEvent e )    {}
	
	public void keyPressed ( KeyEvent e )    {
		int value = e.getKeyCode();
		if ( value == KeyEvent.VK_ENTER )   {
			clear();
			repaint ( );
		}
		
		
		else if (( value == KeyEvent.VK_RIGHT  || value == KeyEvent.VK_LEFT 
				|| 
				value == KeyEvent.VK_UP || value == KeyEvent.VK_DOWN )) {
			if ( value == KeyEvent.VK_RIGHT && x < 11 ) 
				x++;
			else if ( value == KeyEvent.VK_LEFT && x > 0 )
				x--;
			else if ( value == KeyEvent.VK_UP && y > 0 )    
				y--;
			else if ( value == KeyEvent.VK_DOWN && y < 11 ) 
				y++;
			
			
		}
		if(value==KeyEvent.VK_SPACE){
			board[x][y]=(board[x][y]+3)%colors.length;
			
			for(int i=x-2;i<x+3;i++){
				for(int j=y-2;j<y+3;j++){
					if(x==i&&y==j);
					else if(i>=0 && i<12 && j>=0&&j<12){
						if(Math.abs(x-i)>1 || Math.abs(y-j)>1)
							board[i][j]=(board[i][j]+1)%colors.length;
						else
							board[i][j]=(board[i][j]+2)%colors.length;
					}
				}
			}
			
		}
		repaint();
		
	}
	
	public void keyReleased ( KeyEvent e )   {}
	
	
	
	
	public void GiveDirections ( Graphics g )   {
		Font direct  = new Font ( "Serif", Font.BOLD, 40 );
		g.setFont ( direct );
		g.setColor ( Color.blue );
		g.drawString ( "CLICK ON THE APPLET", 50, 100 );
		g.drawString ( "TO BEGIN OR RESUME", 55, 200 );
		g.drawString ( "THE GAME", 180, 300 );
		firsttime=false;
	}
	

}


