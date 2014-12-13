import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid2 extends JApplet implements MouseListener {
	
	private char [][] board ;
	private boolean [][] taken ;
	private char choice;
	private MyPanel canvas;
	private int count;
	
	public  Grid2()    {
		board=new char[4][4];
		taken=new boolean[4][4];
	}
	public void init() {
		int count=49;
		
		for (int i=0;i<board.length;i++){
			for (int j=0;j<board[i].length;j++){
				taken[i][j]=false;
			}
		}
		canvas = new MyPanel(); 
		setContentPane(canvas);
		canvas.setBackground(Color.BLACK);
		canvas.addMouseListener(this);
	}
	class MyPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Draw ( g );
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
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				int c=0;
				if(taken[i][j]==true&&c==0){
					f.setColor(Color.WHITE);
					f.setFont(new Font("serif",Font.BOLD,40));
					f.drawString(" "+count,50,50);
				}
				if(taken[i][j]==true&&c==1)
					f.drawString(" "+count,i*100-40,j*100-40);
				
			}
		}
	}
	
	}
	public void mouseClicked ( MouseEvent e )   {}
	
	public void mousePressed ( MouseEvent e )    {
		int count=0;
		int x=e.getX();
		int y=e.getY();
		for(int a=0;a<board.length;a++){
			for (int b=0;b<board[b].length;b++){
				if(x>=0 && x<=400 &&y>=0 && y<=400&&taken[a][b]==false){
					int row=y/100;
					int col=x/100;
					taken[row][col]=true;
					count++;
					for(int i=1;i<17;i++){
						if( board [row][col] !=i  ){
						}}}}}}
	public void mouseReleased ( MouseEvent e )   {}
	
	public void mouseEntered ( MouseEvent e )   {}
	
	public void mouseExited ( MouseEvent e )     {}
}










