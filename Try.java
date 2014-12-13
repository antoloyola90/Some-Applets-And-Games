//Scott DeRuiter        3/6/2003
//MoveBox.java
//Move a box around, implementing a MouseMotionListener in
//a Swing Applet.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Try extends JApplet implements MouseMotionListener {

private int counter, sizeofarray;
private int [] xpos;
private int [] ypos;
private boolean initialdraw;

private MyPanel canvas;

public Try ()    {
sizeofarray = 100;
counter = 100;
xpos = new int [sizeofarray];
ypos = new int [sizeofarray];
for ( int i = 0; i < xpos.length; i++ )
	xpos[i] = ypos[i] = 0;
initialdraw = true;
}

public void init() {
  	canvas = new MyPanel(); 
  	setContentPane(canvas);
  	canvas.setBackground(Color.blue);
canvas.addMouseMotionListener(this);
}


class MyPanel extends JPanel {

    public void paintComponent(Graphics g) {
  
    	super.paintComponent(g);

	if ( !initialdraw )   {
		for ( int i = xpos.length - 1; i >= 0; i-- )   {
			int value = (i + counter) % 5;
			switch ( value )   {
				case 0:   g.setColor ( Color.white );   break;
				case 1:   g.setColor ( Color.lightGray );   break;
				case 2:   g.setColor ( Color.gray );   break;
				case 3:   g.setColor ( Color.darkGray );   break;
				case 4:   g.setColor ( Color.black );   break;
			}
			if ( i == 0 )
				g.setColor ( Color.blue );
			g.fillOval ( xpos[i] - sizeofarray / 2 + i / 2, 
					ypos[i] - sizeofarray / 2 + i / 2, 
					sizeofarray - i, sizeofarray - i );
			if ( i == 0 )
				g.setColor ( Color.red );
			g.drawOval ( xpos[i] - sizeofarray / 2 + i / 2, 
					ypos[i] - sizeofarray / 2 + i / 2, 
					sizeofarray - i, sizeofarray - i );
		}
	}
	counter--;
	if ( counter == 0 )
		counter = 100;

	for ( int i = xpos.length - 1; i >= 1; i-- )   {
		xpos[i] = xpos[i-1];
		ypos[i] = ypos[i-1];
		ypos[i] -= 3;
	}
  	}
}
	
public void mouseMoved ( MouseEvent e )   {  
xpos[0] = e.getX(); 
ypos[0] = e.getY();
if ( initialdraw )   {
	for ( int i = 0; i < xpos.length; i++ )   {
		xpos[i] = xpos[0];
		ypos[i] = ypos[0];
	}
	initialdraw = false;
}
canvas.repaint();
}

public void mouseDragged ( MouseEvent e )    {
}

}