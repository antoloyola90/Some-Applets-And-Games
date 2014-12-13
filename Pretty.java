import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Pretty extends JApplet   {
 
	private int xpos, ypos,picnum;
	private Image image1,image2,image3;
	private DrawingArea canvas;
	private ButtonPanel buttonPanel;

	public Pretty ( )   {
		xpos = ypos = picnum = 0;
		
	}
 
	public void init ( )  {
		image1 = getImage ( getDocumentBase ( ), "1.jpg" );
		WaitForImage ( this, image1 );
		image2 = getImage ( getDocumentBase ( ), "2.jpg" );
		WaitForImage ( this, image2 );
		image3 = getImage ( getDocumentBase ( ), "3" );
		WaitForImage ( this, image3 );
		
		
		setBackground( Color.pink );

		canvas = new DrawingArea();
		getContentPane().add ( canvas, BorderLayout.CENTER );

       		buttonPanel = new ButtonPanel ( );
       		getContentPane().add ( buttonPanel, BorderLayout.NORTH );
	}
	
	public Insets getInsets() {
      		return new Insets ( 10, 10, 10, 10 );
   	}

	public void WaitForImage ( JApplet component, Image image )   {
		MediaTracker tracker = new MediaTracker ( component );
		try  {
			tracker.addImage ( image, 500 );
			tracker.waitForID ( 500 );
		}
		catch ( InterruptedException e )   {
			e.printStackTrace ( );   
		}
		
	}
 
	class DrawingArea extends JPanel  {
		public void paintComponent ( Graphics g ) {
			boolean b;
			super.paintComponent ( g );
			if(picnum==0)
				b = g.drawImage ( image1, 20, 20, 300, 300, this );
			else if(picnum==1)
				b = g.drawImage ( image2, 20, 20, 300, 300, this );
			else if(picnum==2)
				b = g.drawImage ( image3, 20, 20, 300, 300, this );	
			
	}
	}
	class ButtonPanel extends JPanel implements ActionListener   {

		public ButtonPanel ( )   {
			setBackground ( Color.black );
       
       			JButton audi = new JButton ( "AUDI" );
       			audi.addActionListener ( this );  
       			this.add ( audi );

       			JButton tinkerbell = new JButton ( "TINKERBELL" );
       			tinkerbell.addActionListener ( this );
       			this.add ( tinkerbell );

       			JButton man = new JButton ( "COOl-MAN" );
       			man.addActionListener ( this );
       			this.add ( man );

		}

   		public void actionPerformed ( ActionEvent evt ) {
      			String command = evt.getActionCommand();
               
      			if ( command.equals ( "AUDI" ) )
 	        		picnum = 0;
      			else if ( command.equals ( "TINKERBELL" ) )
         			picnum = 1;
      			else if ( command.equals ( "COOl-MAN" ) )
         			picnum = 2;
      			canvas.repaint();
   		}
	}
}

