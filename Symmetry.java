//	Anto Loyola		4/14/05
//	Symmetry.java
//	This program has 5 color buttons on the top  and 4 symmetry buttons and a clear button on the bottom. The four buttons on the bottom are
//	the "one" symmetry, the "two" symmetry, the "four" symmetry, and the "eight" symmetry. As you press each of these the function will be
//	done and you can draw. Have a great time drawing.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Symmetry extends JApplet implements 
MouseListener,MouseMotionListener {
	
	private DisplayPanel canvas;
	private ButtonPanel buttonPanel;
	private ButtonPanel2 buttonPanel2;
	
	private int number=0,num=0,x=0,y=0,x1=0,y1=0;
	
	
	public Symmetry ( )   {
		
	}
	
	public void init() {
		canvas = new DisplayPanel();
		getContentPane().add ( canvas, BorderLayout.CENTER );
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		
		buttonPanel = new ButtonPanel ( );
		getContentPane().add ( buttonPanel, BorderLayout.NORTH );
		
		buttonPanel2 = new ButtonPanel2 ( );
		getContentPane().add ( buttonPanel2, BorderLayout.SOUTH );
	}
	
	public Insets getInsets() {
		return new Insets ( 10, 10, 10, 10 );
	}
	
	class DisplayPanel extends JPanel  {
		
		public DisplayPanel ( )   {
			setBackground ( Color.yellow );
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent ( g );
			
			
			//g.setColor(Color.green);
			
			
		}
		public void Set(){
			Graphics g =getGraphics();
			switch(number){
			case 0:g.setColor(Color.green);break;
			case 1:g.setColor(Color.green);break;
			case 2:g.setColor(Color.red);break;
			case 3:g.setColor(Color.blue);break;
			case 4:g.setColor(Color.white);break;
			case 5:g.setColor(Color.orange);break;
			}
			switch(num){
			case 0:g.fillOval(x1,y1,10,10);break;
			case 1:g.fillOval(x1,y1,10,10);break;
			case 2:g.fillOval(x1,y1,10,10);
			g.fillOval(500-x1,y1,10,10);break;
			case 3:g.fillOval(x1,y1,10,10);
			g.fillOval(500-x1,y1,10,10);
			g.fillOval(x1,500-y1,10,10);
			g.fillOval(500-x1,500-y1,10,10);break;
			case 4:g.fillOval(x1,y1,10,10);
			g.fillOval(500-x1,y1,10,10);
			g.fillOval(x1,500-y1,10,10);
			g.fillOval(500-x1,500-y1,10,10);
			
			g.fillOval(y1,x1,10,10);
			g.fillOval(500-y1,x1,10,10);
			g.fillOval(y1,500-x1,10,10);
			g.fillOval(500-y1,500-x1,10,10);
			break;
			
			}
		}
	}
	
	class ButtonPanel extends JPanel implements ActionListener   {
		
		public ButtonPanel ( )   {
			setBackground ( Color.red );
			
			JButton green = new JButton ( "GREEN" );
			green.addActionListener ( this );
			this.add ( green );
			
			JButton red = new JButton ( "RED" );
			red.addActionListener ( this );
			this.add ( red );
			
			JButton blue = new JButton ( "BLUE" );
			blue.addActionListener ( this );
			this.add ( blue );
			
			JButton white = new JButton ( "WHITE" );
			white.addActionListener ( this );
			this.add ( white );
			
			JButton orange = new JButton ( "ORANGE" );
			orange.addActionListener ( this );
			this.add ( orange );
		}
		
		public void actionPerformed ( ActionEvent evt ) {
			String command = evt.getActionCommand();
			
			if ( command.equals ( "GREEN" ) )
				number=1;
			else if ( command.equals ( "RED" ) )
				number=2;
			else if ( command.equals ( "BLUE" ) )
				number=3;
			else if ( command.equals ( "WHITE" ) )
				number=4;
			else if ( command.equals ( "ORANGE" ) )	
				number=5;
		}
	}
	class ButtonPanel2 extends JPanel implements ActionListener   {
		
		public ButtonPanel2 ( )   {
			setBackground ( new Color((int)(Math.random()*255),(int)(Math.random()*50),(int)(Math.random()*185)) );
			
			JButton one = new JButton ( "ONE" );
			one.addActionListener ( this );
			this.add ( one );
			
			JButton two = new JButton ( "TWO" );
			two.addActionListener ( this );
			this.add ( two );
			
			JButton four = new JButton ( "FOUR" );
			four.addActionListener ( this );
			this.add ( four );
			
			JButton eight = new JButton ( "EIGHT" );
			eight.addActionListener ( this );
			this.add ( eight );
			
			JButton clear = new JButton ( "CLEAR" );
			clear.addActionListener ( this );
			this.add ( clear );
		}
		
		public void actionPerformed ( ActionEvent evt ) {
			String command = evt.getActionCommand();
			
			if ( command.equals ( "ONE" ) )
				num=1;
			else if ( command.equals ( "TWO" ) )
				num=2;
			else if ( command.equals ( "FOUR" ) )
				num=3;
			else if ( command.equals ( "EIGHT" ) )
				num=4;
			else if ( command.equals ( "CLEAR" ) )	
				canvas.repaint();
		}
	}
	public void mouseClicked ( MouseEvent e )   {}
	
	public void mousePressed ( MouseEvent e )    {
		Graphics g=getGraphics();
		x1=e.getX();
		y1=e.getY();
		canvas.Set();
		
		
	}
	
	public void mouseReleased ( MouseEvent e )   {
	}
	
	public void mouseEntered ( MouseEvent e )   {}
	
	public void mouseExited ( MouseEvent e )     {}
	
	public void mouseMoved(MouseEvent e){}
	public void mouseDragged(MouseEvent e){
		Graphics g=getGraphics();
		x1=e.getX();
		y1=e.getY();
		canvas.Set();
		
	}
	
	
}

