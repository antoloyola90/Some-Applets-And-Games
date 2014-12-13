import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tennis extends JApplet implements 
MouseListener {
	
	private DisplayPanel canvas;
	private ButtonPanel2 buttonPanel2;
	
	private int number=0,num=0;
	
	
	public Tennis ( )   {
		
	}
	
	public void init() {
		canvas = new DisplayPanel();
		getContentPane().add ( canvas, BorderLayout.CENTER );
		canvas.addMouseListener(this);
		
		
		
		
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
		/*public void Set(){
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
			
			}*/
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
			
			
		}
		
		public void actionPerformed ( ActionEvent evt ) {
			String command = evt.getActionCommand();
		/*	
			if ( command.equals ( "ONE" ) )
				num=1;
			else if ( command.equals ( "TWO" ) )
				num=2;
			*/
		
	}
	public void mouseClicked ( MouseEvent e )   {}
	
	public void mousePressed ( MouseEvent e )    {
		
	}
	
	public void mouseReleased ( MouseEvent e )   {
	}
	
	public void mouseEntered ( MouseEvent e )   {}
	
	public void mouseExited ( MouseEvent e )     {}
	
	//public void mouseMoved(MouseEvent e){}
	//public void mouseDragged(MouseEvent e){
	}
	
	
}

