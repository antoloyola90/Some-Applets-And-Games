/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DadGraphics2 {
	public static void main(String[] args) throws Exception {
		JFrame f=new JFrame("Anto's first window");
		for (int i=0;i<256;i++){
			for (int j=0;j<256;j++){
				for (int c=0;c<256;c++){
					Color abc=new Color(i,j,c);
					f.setColor(abc);
					f.setSize(200,200);
					JLabel label=new JLabel("Hello, Shanthi!");
					label.setFont(new Font("Algerian", 0, 30));
					f.addMouseMotionListener(new Mouse(label));
					f.getContentPane().add(label);
					f.setVisible(true);
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
*/