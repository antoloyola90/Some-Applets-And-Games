import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Me extends JApplet   {
 
	private int xpos, ypos,picnum;
	private Image image1,image2,image3,image4,image5;
	private DrawingArea canvas;
	private ButtonPanel buttonPanel;

	public Me ( )   {
		xpos = ypos = picnum = 0;
		
	}
 
	public void init ( )  {
		image1 = getImage ( getDocumentBase ( ), "1.jpg" );
		WaitForImage ( this, image1 );
		image2 = getImage ( getDocumentBase ( ), "2.jpg" );
		WaitForImage ( this, image2 );
		image3 = getImage ( getDocumentBase ( ), "3.jpg" );
		WaitForImage ( this, image3 );
		image4 = getImage ( getDocumentBase ( ), "4.jpg" );
		WaitForImage ( this, image4 );
		image5 = getImage ( getDocumentBase ( ), "5.jpg" );
		WaitForImage ( this, image5 );
		
		
		setBackground( Color.pink );

		canvas = new DrawingArea();
		getContentPane().add ( canvas, BorderLayout.CENTER );

       		buttonPanel = new ButtonPanel ( );
       		getContentPane().add ( buttonPanel, BorderLayout.SOUTH );
	}
	
	public Insets getInsets() {
      		return new Insets ( 10, 10, 10, 10 );
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
 
	class DrawingArea extends JPanel  {
		public void paintComponent ( Graphics g ) {
			boolean b;
			super.paintComponent ( g );
		
			if(picnum==1){
				b = g.drawImage ( image2, 0, 20, 500, 500, this );
			}
			else if(picnum==2){
				b = g.drawImage ( image3, 0, 20, 500, 500, this );
			}
			else if(picnum==3){
				b = g.drawImage ( image4, 0, 20, 500, 500, this );
			}
			else if(picnum==4){
				b = g.drawImage ( image5, 0, 20, 500, 500, this );
			}	
			
	}
	}
	class ButtonPanel extends JPanel implements ActionListener   {

		public ButtonPanel ( )   {
			setBackground ( Color.black );
       
       			JButton anto = new JButton ( "ANTO" );
       			anto.addActionListener ( this );  
       			this.add ( anto );

       			JButton family = new JButton ( "SISTER" );
       			family.addActionListener ( this );
       			this.add ( family );

       			JButton interests = new JButton ( "FAMILY" );
       			interests.addActionListener ( this );
       			this.add ( interests );
			
			JButton team = new JButton ( "TENNIS" );
       			team.addActionListener ( this );
       			this.add ( team );

       			JButton tennis = new JButton ( "FRIENDS" );
       			tennis.addActionListener ( this );
       			this.add ( tennis );

		}

   		public void actionPerformed ( ActionEvent evt ) {
      			String command = evt.getActionCommand();
               
      			if ( command.equals ( "ANTO" ) )
 	        		picnum = 0;
			else if ( command.equals ( "SISTER" ) )
         			picnum = 1;
			else if ( command.equals ( "FAMILY" ) )
         			picnum = 2;
			else if ( command.equals ( "TENNIS" ) )
         			picnum = 3;
			else if ( command.equals ( "FRIENDS" ) )
         			picnum = 4;
				
      			canvas.repaint();
   		}
		
	}
}
