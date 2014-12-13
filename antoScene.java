

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.event.*;

	public class antoScene extends JApplet {
		private ImagePanel panel1;
		private AllButtonsPanel panel2;
		private JSlider bottom;
		private JScrollBar left;
		private JRadioButton one, two, three, four; 
		private int width, height, value;
		private boolean yessnow,yesgrid;
		
		public void init ( )  {
			yessnow = yesgrid=false;
			width = 300;
			height = 600;
			Container contentPane = getContentPane();
			contentPane.setLayout ( new GridLayout ( 1, 2, 5, 5 ) );
			contentPane.setBackground ( Color.black );
			
			panel1 = new ImagePanel ( );
			panel1.setBackground( Color.blue );
			contentPane.add ( panel1 );
			
			panel2 = new AllButtonsPanel ( );
			panel2.setBackground( Color.red );
			contentPane.add ( panel2 );
		}
		
		class ImagePanel extends JPanel implements ChangeListener, AdjustmentListener   {
			private Image [] image;
			
			public ImagePanel ( )   {
				this.setLayout ( new BorderLayout ( ) );
				
				value = 0;
				image = new Image[4];		
				for ( int i = 0; i < image.length; i++ )   {
					image[i] = getImage ( getDocumentBase ( ), "pic" + i + ".jpg" );
					WaitForImage ( this, image[i] );
				}
				
				bottom = new JSlider ( JSlider.VERTICAL, 0, 300, 300 );
				this.add ( bottom, BorderLayout.NORTH );
				bottom.addChangeListener ( this );
				
				left = new JScrollBar ( JScrollBar.HORIZONTAL, 600, 0, 0, 600 );
				left.addAdjustmentListener ( this );
				this.add ( left, BorderLayout.EAST );
			}
			
			public void WaitForImage ( JPanel component, Image image )   {
				MediaTracker tracker = new MediaTracker ( component );
				try  {
					tracker.addImage ( image, 0 );
					tracker.waitForID ( 0 );
				}
				catch ( InterruptedException e )   {
					e.printStackTrace ( );   
				}
			}
			
			public void paintComponent ( Graphics g ) {
			 super.paintComponent ( g );
			 g.drawImage ( image[value], 0, 0, width, height, this );
			 if ( yesgrid )  {
			 g.setColor ( Color.white );
			 for ( int i = 0; i < 10; i++ )
			 g.fillRect ( (int)(i * (double)width / 10), 0, 2, height );
			 for ( int i = 0; i < 10; i++ )
			 g.fillRect ( 0, (int)(i * (double)height / 10), width, 2 );
			 }
			 if ( yessnow )  {
			 g.setColor ( Color.white );
			 for ( int i = 0; i < 200; i++ )   {
			 int x = (int)(Math.random() * width);
			 int y = (int)(Math.random() * height);
			 g.fillOval ( x, y, 6, 6 );
			 }
			 }
			 }
			
			public void stateChanged ( ChangeEvent evt )   {
				width = bottom.getValue();
				this.repaint ( );
			}
			
			public void adjustmentValueChanged( AdjustmentEvent e){
				height = left.getValue();
				this.repaint();
			}
		}
		
		class AllButtonsPanel extends JPanel {
			RadioPanel rpanel;
			ButtonPanel bpanel;
			
			public AllButtonsPanel ( )   {
				this.setLayout ( new GridLayout ( 2, 1, 5, 5 ) );
				
				rpanel = new RadioPanel ( );
				rpanel.setBackground( Color.RED );
				this.add ( rpanel );
				
				bpanel = new ButtonPanel ( );
				bpanel.setBackground( Color.GREEN );
				this.add ( bpanel );
			}
			
			public void paintComponent ( Graphics g ) {
				super.paintComponent ( g );
			}
		} 
		
		class RadioPanel extends JPanel implements ActionListener   {
			
			public RadioPanel  ( )   {
				this.setLayout( new GridLayout ( 1, 4 ) );
				
				ButtonGroup imageGroup = new ButtonGroup();
				
				one = new JRadioButton ( "FIRST IMAGE" );
				imageGroup.add ( one );
				one.addActionListener ( this );
				this.add ( one );
				
				two = new JRadioButton ( "SECOND IMAGE" );
				imageGroup.add ( two );
				two.addActionListener ( this );
				this.add ( two );
				
				three = new JRadioButton ( "THIRD IMAGE" );
				imageGroup.add ( three );
				three.addActionListener ( this );
				this.add ( three );
				
				four = new JRadioButton ( "FOURTH IMAGE" );
				imageGroup.add ( four );
				four.addActionListener ( this );
				this.add ( four );
				
			}
			
			public void paintComponent ( Graphics g ) {
				super.paintComponent ( g );
			}
			
			public void actionPerformed ( ActionEvent evt ) {
				if ( one.isSelected() )
					value = 0;
				else if ( two.isSelected() )
					value = 1;
				else if ( three.isSelected() )
					value = 2;
				else if ( four.isSelected() )
					value = 3;
				panel1.repaint ( );
			}
		}
		
		class ButtonPanel extends JPanel implements ActionListener   {
			JButton snow, grid, reset;
			
			public ButtonPanel ( )   {
				this.setLayout( new FlowLayout ( FlowLayout.RIGHT, 140, 50 ) );
				
				snow = new JButton ( "SNOW" );
				snow.addActionListener ( this );  
				this.add ( snow );
				
				grid = new JButton ( "GRID" );
				grid.addActionListener ( this );  
				this.add ( grid );
				
				reset = new JButton ( "RESET" );
				reset.addActionListener ( this );  
				this.add ( reset );
				
				one.setSelected(true); 
			}
			
			public void paintComponent ( Graphics g ) {
				super.paintComponent ( g );
			}
			
			public void actionPerformed ( ActionEvent evt ) {
				String command = evt.getActionCommand();
				
				if ( command.equals ( "SNOW" ) )   {
					yessnow = true;
					panel1.repaint ( );
				}
				else if ( command.equals ( "GRID" ) )   {
					yesgrid = true;
					panel1.repaint ( );
				}
				if ( command.equals ( "RESET" ) )   {
					value = 0;
					width = 300;
					height = 600;
					yessnow = yesgrid = false;
					left.setValue ( 600 );
					bottom.setValue ( 300 );
					one.setSelected(true); 
					panel1.repaint ( );
				}
			}
			
		}
	}

	
