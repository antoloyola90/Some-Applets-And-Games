/*import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.applet.Applet;

import javax.swing.JLabel;

import FirstApplet.Mouse;

public class FirstApplet extends Applet {
	public void paint (Graphics g) {*/
		/*for (int i=0;i<256;i++){
			for (int j=0;j<256;j++){
				for (int c=0;c<256;c++){
					Color abc=new Color(i,j,c);
					g.setColor(abc);
					g.fillRect (30, 100, 80, 40);
					g.fillRoundRect(150, 150,150, 150, 150, 150);
					g.setFont(new Font("Dialog", Font.BOLD, 14));
					g.drawString("Hello, Shanthi", 30, 30);
					/*g.drawRect (30, 30, 80, 40);
					g.drawOval (120, 30, 50, 50);
					g.setColor (Color.red);
					g.fillRect (30, 100, 80, 40);
					g.fillOval (120, 100, 50, 50);
					g.drawLine (30, 160, 130, 170);
					g.drawArc (30, 180, 50, 50, 60, 40);
					g.fillArc (120, 180, 50, 50, 60, 40);*/
				/*}
			}
		}*/
		/*for (int i=0;i<256;i++){
			for (int j=0;j<256;j++){
				for (int c=0;c<256;c++){
					Color abc=new Color(i,j,c);
					g.setColor(abc);
					g.setSize(200,200);
					JLabel label=new JLabel("Hello, Shanthi!");
					label.setFont(new Font("Algerian", 0, 30));
					g.addMouseMotionListener(new Mouse(label));
					g.getContentPane().add(label);
					g.setVisible(true);
				}
			}
		}
	}
		
		class Mouse extends MouseMotionAdapter {
			JLabel label;
			public Mouse(JLabel lab) {
				label=lab;
			}
			public void mouseMoved(MouseEvent e) {
				int x=e.getX(), y=e.getY()-550;
				int ox=(int)label.getLocation().getX(), oy=(int)label.getLocation().getY();
				int nx=x,ny=y,ooy=oy,oox=ox;
				//		label.setText(nx+","+ny);
				if (x<ox) {
					int t=x;
					x=ox;
					ox=t;
				}
				if (y<oy) {
					int t=y;
					y=oy;
					oy=t;
				}
				for (int i=ox;i<=x;i+=5) {
					label.setLocation(i,ooy);
					try {Thread.sleep(1);}catch(Exception ee){}
				}
				for (int i=oy;i<=y;i+=5) {
					label.setLocation(nx,i);
					try {Thread.sleep(1);}catch(Exception ee){}
				}
			}
		}
		
	}
	
}*/
