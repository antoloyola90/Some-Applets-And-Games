import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Resize1 extends JApplet implements MouseListener, MouseMotionListener {
 
	private int xpos, ypos, width, height;
	private Image image;
	private DrawingArea draw;

	public Resize1 ( )   {
		xpos = ypos = width = height = 0;
	}
 
	public void init ( )  {
		draw = new DrawingArea ( );
		setContentPane ( draw );
		draw.setBackground ( Color.gray );
		draw.addMouseListener(this);
		draw.addMouseMotionListener(this);
		image = getImage ( getDocumentBase ( ), "Blue hills.jpg" );
		WaitForImage ( this, image );
	}

	public void WaitForImage ( JApplet component, Image image )   {
		MediaTracker tracker = new MediaTracker ( component );
		try  {
			tracker.addImage ( image, 0 );
			tracker.waitForID ( 0 );
		}
		catch ( InterruptedException e )   {
			e.printStackTrace ( );   
		}
	}
 
	class DrawingArea extends JPanel {
		public void paintComponent ( Graphics g ) {
			super.paintComponent ( g );
			boolean b = g.drawImage ( image, xpos, ypos, width, height, draw );
		
			
		}
	}

	public void mouseMoved ( MouseEvent e )    {}
	public void mouseDragged ( MouseEvent e )    {
		width  = e.getX ( ) - xpos;
		height = e.getY ( ) - ypos;
		draw.repaint ( );
	}
 
	public void mousePressed ( MouseEvent e )   {
		xpos = e.getX ( );
		ypos = e.getY ( );
		width = height = 0;
		draw.repaint ( );
	}

	public void mouseReleased ( MouseEvent e )    {
		draw.repaint ( );
	}

	public void mouseClicked ( MouseEvent e )    {}
	public void mouseEntered ( MouseEvent e )    {}
	public void mouseExited ( MouseEvent e )    {}
}
