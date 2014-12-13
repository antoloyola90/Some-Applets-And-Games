//	Anto Loyola		4/4/05
//	Tile.java
//	This program allows you to navigate through a tile field and as you press enter it will change the color you are on by two, the ones 
//	immediately around you by two and the ones completely around you by 1, then you  press enter to start all over again!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Tile extends JApplet implements KeyListener, 
FocusListener, MouseListener   {
	private int [][]board;
	private int x=0,y=0,num=0;
	private Color[]colors=new Color[]{Color.white,Color.red,Color.blue,
			Color.green,Color.yellow,Color.pink,Color.black};
	private boolean firsttime=true;
	
	
	public Tile ( )   {
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
	
	
	
	public void paint(Graphics g) {
		
		if ( firsttime )   {
			GiveDirections ( g );
			
		}
		else   {
			for ( int i = 0; i < 12; i++ )   
				for ( int k = 0; k < 12; k++ ) {  
					g.drawLine(k*50,0,k*50,600);
					g.drawLine(0,i*50,600,i*50);
				}
			for ( int i = 0; i < 12; i++ )  { 
				for ( int k = 0; k < 12; k++ ) { 
					int b=board[i][k];
					g.setColor(colors[b]);
					g.fillRect(i*50+1,k*50+1,49,49);
					
				}
			}
			
			g.setColor(Color.lightGray);
			g.fillRect(x*50+1,y*50+1,49,49);
		}
		
		
	}
	
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



