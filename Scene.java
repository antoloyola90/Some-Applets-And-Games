import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//import java.lang.*;


public class Scene extends JApplet implements ChangeListener {
	
	private JSlider redSlider, greenSlider, blueSlider;   
	private JLabel redLabel, greenLabel, blueLabel;  
	private JPanel colorPatch;
	//private ImagePanel panel1;
	//private AllButtonsPanel panel2;
	private JSlider bottom;
	private JScrollBar left;
	 
	private int width, height,prevX, prevY;
	private boolean yessnow, yesgrid,dragging;
	private JComboBox colorChoice;
	private Graphics graphicsForDrawing;
	SimplePaintCanvas canvas =null;
	
	
	public Scene() {
		
		setBackground(Color.gray);         // Background color of applet.
		
		canvas= new SimplePaintCanvas();  
		getContentPane().add(canvas,BorderLayout.CENTER);
		
		JPanel buttonBar = new JPanel();      
		buttonBar.setBackground(Color.gray);
		getContentPane().add(buttonBar, BorderLayout.SOUTH);
		
		colorChoice = new JComboBox();  
		colorChoice.addItem("Black");
		colorChoice.addItem("Red");
		colorChoice.addItem("Green");
		colorChoice.addItem("Blue");
		colorChoice.addItem("Cyan");
		colorChoice.addItem("Magenta");
		colorChoice.addItem("Yellow");
		colorChoice.addItem("White");
		colorChoice.setBackground(Color.white);
		buttonBar.add(colorChoice);
		
		JButton fill = new JButton("Set Background");  
		fill.addActionListener(canvas);
		fill.setBackground(Color.ORANGE);
		buttonBar.add(fill);
		
		JButton clear = new JButton("Clear");   // The second button.
		clear.addActionListener(canvas);
		clear.setBackground(Color.ORANGE);
		buttonBar.add(clear);
		
	}
	
	
	public void init ( )  {
		yessnow = yesgrid = false;
		width = 300;
		height = 600;
		Container contentPane = getContentPane();
		contentPane.setLayout ( new GridLayout ( 1, 2, 5, 5 ) );
		contentPane.setBackground ( Color.BLUE );
		
		/*panel1 = new ImagePanel ( );
		panel1.setBackground( Color.blue );
		contentPane.add ( panel1 );
		
		panel2 = new AllButtonsPanel ( );
		panel2.setBackground( Color.red );
		contentPane.add ( panel2 );
		
		
		
		/* Create JSliders with possible values from 0 to 255. */
		
		redSlider = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		greenSlider = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		blueSlider = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		
		/* Create JLabels showing current RGB and HSB values. */
		
		redLabel = new JLabel(" R = 0");
		greenLabel = new JLabel(" G = 0");
		blueLabel = new JLabel(" B = 0");
		
		/* Set the colors of the labels, and make them opaque */
		
		
		redLabel.setBackground(Color.BLUE);
		redLabel.setForeground(Color.red);
		redLabel.setOpaque(true);
		greenLabel.setBackground(Color.YELLOW);
		greenLabel.setForeground(new Color(0,150,0));
		greenLabel.setOpaque(true);
		blueLabel.setBackground(Color.PINK);
		blueLabel.setForeground(Color.blue);
		blueLabel.setOpaque(true);
		
		/* Set the applet to listen for changes to the JSliders' values 
		 */
		
		redSlider.addChangeListener(this);
		greenSlider.addChangeListener(this);
		blueSlider.addChangeListener(this);
		
		/* Create a JPanel whose background color will always be set to 
		 the
		 currently selected color.  Otherwise, the panel is empty. */
		
		colorPatch = new JPanel();
		colorPatch.setBackground(Color.black);
		
		/* Create the applet layout, which consists of a row of
		 three equal-sized regions holding the JSliders,
		 the Labels, and the color patch.  The background color
		 of the applet is gray, which will show around the edges
		 and between components. */
		
		setBackground(Color.gray);
		getContentPane().setBackground(Color.gray);
		
		getContentPane().setLayout(new GridLayout(1,3,3,3));
		JPanel scrolls = new JPanel();
		JPanel labels = new JPanel();
		scrolls.setBackground(Color.gray);
		labels.setBackground(Color.gray);
		getContentPane().add(scrolls);
		getContentPane().add(labels);
		getContentPane().add(colorPatch);
		
		/* Add the JSliders and the JLabels to their respective panels. 
		 */
		
		scrolls.setLayout(new GridLayout(3,1,2,2));
		scrolls.add(redSlider);
		scrolls.add(greenSlider);
		scrolls.add(blueSlider);
		
		labels.setLayout(new GridLayout(3,1,2,2));
		labels.add(redLabel);
		labels.add(greenLabel);
		labels.add(blueLabel);
		
		
		
		
		
		
	}
	
	public void stateChanged(ChangeEvent evt) {
		int r = redSlider.getValue();
		int g = greenSlider.getValue();
		int b = blueSlider.getValue();
		redLabel.setText(" R = " + r);
		greenLabel.setText(" G = " + g);
		blueLabel.setText(" B = " + b);
		colorPatch.setBackground(new Color(r,g,b));
	} 
	
	
	public Insets getInsets() {
		return new Insets(3,3,3,3);
	}	
		
		public void mousePressed (MouseEvent evt) {
			
			
			if (dragging == true)  
				
				prevX = evt.getX();    // Start drawing.
			prevY = evt.getY();
			dragging = true;
			graphicsForDrawing = getGraphics();
			graphicsForDrawing.setColor(canvas.getCurrentColor());
			
		} // end mousePressed()
		
		
		public void mouseReleased(MouseEvent evt) {
			
			if (dragging == false)
				return;  // Nothing to do because the user isn't drawing.
			dragging = false;
			graphicsForDrawing.dispose();
			graphicsForDrawing = null;
		}
		
		
		public void mouseDragged(MouseEvent evt) {
			
			
			if (dragging == false)
				return;  
			
			int x = evt.getX();   
			int y = evt.getY();   
			
			
			
			prevX = x;  
			prevY = y;
			
		} 
		
		
		public void mouseEntered(MouseEvent evt) { }   
		public void mouseExited(MouseEvent evt) { }    
		public void mouseClicked(MouseEvent evt) { }   
		public void mouseMoved(MouseEvent evt) { } 
	}
	
	
	
	class SimplePaintCanvas extends JPanel 
	implements MouseListener, MouseMotionListener, 
	ActionListener {
		
		private Panel panel1;
		private AllButtonsPanel panel2;
		private JRadioButton one, two, three, four;
		private final static int 
		BLACK = 0,
		RED = 1,            
		GREEN = 2,         
		BLUE = 3,           
		CYAN = 4,           
		MAGENTA = 5,
		YELLOW = 6;
		private int value=0;
		
		private JComboBox colorChoice;
		
		private int prevX, prevY;     
		private boolean dragging;     
		
		private Graphics graphicsForDrawing,g;  
		
		SimplePaintCanvas() {
			
			addMouseListener(this);
			addMouseMotionListener(this);
			setBackground(Color.red);
			
			colorChoice=new JComboBox();
			colorChoice.add("Black", this);
			colorChoice.add("RED", this);
			colorChoice.add("GREEN", this);
			colorChoice.add("BLUE", this);
			colorChoice.add("CYAN", this);
			colorChoice.add("MAGENTA", this);
			colorChoice.add("YELLOW", this);
			colorChoice.add("WHITE", this);
			
			
		}
		
		
		public void actionPerformed(ActionEvent evt) {
			// Respond when the user clicks on a button.
			String command = evt.getActionCommand();
			if (command.equals("Clear")) {
				// Clear to current background color.
				repaint();
			}
			else if (command.equals("Set Background")) {
				
				setBackground(getCurrentColor());
				
				
				if (colorChoice.getSelectedIndex() == 0)
					colorChoice.setSelectedIndex(7);
				else
					colorChoice.setSelectedIndex(0);
				
			
			}
		}
		
		
		public Color getCurrentColor() {
			
			int currentColor = colorChoice.getSelectedIndex();
			switch (currentColor) {
			case BLACK:
				return Color.black;
			case RED:
				return Color.red;
			case GREEN:
				return Color.green;
			case BLUE:
				return Color.blue;
			case CYAN:
				return Color.cyan;
			case MAGENTA:
				return Color.magenta;
			case YELLOW:
				return Color.yellow;
			default:
				return Color.white;
			}
			
		}
		
		class AllButtonsPanel extends JPanel {
			RadioPanel rpanel;
			
			
			public AllButtonsPanel ( )   {
				this.setLayout ( new GridLayout ( 2, 1, 5, 5 ) );
				
				rpanel = new RadioPanel ( );
				rpanel.setBackground( Color.yellow );
				this.add ( rpanel );
				
			
			}
			
			public void paintComponent ( Graphics g ) {
				super.paintComponent ( g );
			}
		} 
		
		class RadioPanel extends JPanel implements ActionListener   {
			
			public RadioPanel ( )   {
				this.setLayout( new GridLayout ( 4, 1 ) );
				
				ButtonGroup imageGroup = new ButtonGroup();
				
				one = new JRadioButton ( "RECT" );
				imageGroup.add ( one );
				one.addActionListener ( this );
				this.add ( one );
				
				two = new JRadioButton ( "OVAL" );
				imageGroup.add ( two );
				two.addActionListener ( this );
				this.add ( two );
				
				three = new JRadioButton ( "LINE" );
				imageGroup.add ( three );
				three.addActionListener ( this );
				this.add ( three );
				
				
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
				
				panel1.repaint ( );
			}
		}
		
		public void mousePressed(MouseEvent evt) {
			
			
			if (dragging == true)  
				
				prevX = evt.getX();   
			prevY = evt.getY();
			dragging = true;
			graphicsForDrawing = getGraphics();
			graphicsForDrawing.setColor(getCurrentColor());
			
		} 
		
		
		public void mouseReleased(MouseEvent evt) {
			
			if (dragging == false)
				return; 
			dragging = false;
			graphicsForDrawing.dispose();
			graphicsForDrawing = null;
		}
		
		
		public void mouseDragged(MouseEvent evt) {
			
			
			if (dragging == false)
				return;  
			
			int x = evt.getX();   
			int y = evt.getY();   
			
			//graphicsForDrawing.drawLine(prevX, prevY, x, y); 
			
			prevX = x;  
			prevY = y;
			graphicsForDrawing.setColor(Color.BLACK);
			switch (value){
				
				case 0: graphicsForDrawing.fillRect(prevX, prevY, 10, 10);break;
				case 1: graphicsForDrawing.fillOval(prevX, prevY, 10, 10);break;
				case 2: graphicsForDrawing.drawLine(prevX, prevY, x, y);break;
				
			}
			//repaint();
			
			
			
			
		} // end mouseDragged.
		
		
		public void mouseEntered(MouseEvent evt) { }   
		public void mouseExited(MouseEvent evt) { }    
		public void mouseClicked(MouseEvent evt) { }   
		public void mouseMoved(MouseEvent evt) { } 
		
	}
	