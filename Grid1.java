import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid1 extends JApplet implements MouseListener {
	private int x, y,count;
	private MyPanel canvas;
	private boolean [][] check=new boolean [4][4];
	
	public static void main(String[] args) {
	}
	
	public Grid1 ()    {
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				check[i][j]=false;
			}
		}
		x = y = 0;
	}
	
	public void init() {
		canvas = new MyPanel(); 
		setContentPane(canvas);
		canvas.setBackground(Color.BLACK);
		canvas.addMouseListener(this);
	}
	
	
	class MyPanel extends JPanel {		
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Draw ( g );
			B(g);
		}
		public void Draw(Graphics f){
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					f.setColor(Color.WHITE);
					f.drawLine(i*100,0,i*100,400);
					f.drawLine(i*100+1,0,i*100+1,400);
					f.drawLine(0,j*100,400,j*100);
					f.drawLine(0,j*100+1,400,j*100+1);
				}
			}
		}}
	
	public void mouseClicked ( MouseEvent e )   {
		count++;
		if ( e.isShiftDown() ) {
			repaint();
			return;
		}
		
		x = e.getX();
		y = e.getY();
		int a=0,b=0;
		a=x%100;
		b=y%100;
		for(int i=1;i<5;i++){
			for(int j=1;j<5;j++){
				if(a<(i*100) && b<(j*100))
					check[i-1][j-1]=true;
			}
		}
	}
	public void mousePressed ( MouseEvent e )    { 
		
	}
	public void mouseReleased ( MouseEvent e )   {}
	public void mouseEntered ( MouseEvent e )   {}
	public void mouseExited ( MouseEvent e )     {}
	public void B ( Graphics f )   {
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				int c=0;
				if(check[i][j]==true&&c==0){
					f.setColor(Color.WHITE);
					f.setFont(new Font("serif",Font.BOLD,40));
					f.drawString(" "+count,50,50);c++;
				}
				if(check[i][j]==true&&c==1)
					f.drawString(" "+count,i*100-40,j*100-40);
				
			}
		}
	}
}