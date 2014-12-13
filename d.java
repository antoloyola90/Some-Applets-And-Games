import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class d extends JApplet implements MouseListener {

	/*class Three {
		char[][] sboard=new char[3][3];
	}
	class Tak {
		boolean [][] gboard=new boolean [3][3];
	}*/
	
	//private Three[][] threes=new Three[3][3];
	//private Tak [][] taken=new Tak [3][3];
	private boolean [][] taken=new boolean[3][3];
	private boolean [][] taken1=new boolean[3][3];
	private boolean [][] taken2=new boolean[3][3];
	private boolean [][] taken3=new boolean[3][3];
	private boolean [][] taken4=new boolean[3][3];
	private boolean [][] taken5=new boolean[3][3];
	private boolean [][] taken6=new boolean[3][3];
	private boolean [][] taken7=new boolean[3][3];
	private boolean [][] taken8=new boolean[3][3];
	private Color [] color;
	//private int [] rect, rect1;
	//private boolean player1turn, winner, done;

	private MyPanel canvas;

	private int count,l, row, col;

	

	public d() {
		/*
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
			threes[i][j]=new Three();
		
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
			taken[i][j]=new Tak();*/
		color= new Color[9];
		color= new Color[]{Color.blue, Color.black, Color.cyan, Color.green, Color.magenta, Color.red, Color.yellow, Color.pink, Color.orange};
		
		
	}

	public void init() {
		
		canvas = new MyPanel();
		setContentPane(canvas);
		canvas.setBackground(Color.BLACK);
		canvas.addMouseListener(this);
	}

	class MyPanel extends JPanel {

		public void paint(Graphics g) {
			g.setColor(color[0]);
			g.fillRect(0*90, 0*90, 90, 90);g.setColor(color[1]);
			g.fillRect(1*90, 0*90, 90, 90);g.setColor(color[2]);
			g.fillRect(2*90, 0*90, 90, 90);g.setColor(color[3]);
			g.fillRect(0*90, 1*90, 90, 90);g.setColor(color[4]);
			g.fillRect(1*90, 1*90, 90, 90);g.setColor(color[5]);
			g.fillRect(2*90, 1*90, 90, 90);g.setColor(color[6]);
			g.fillRect(0*90, 2*90, 90, 90);g.setColor(color[7]);
			g.fillRect(1*90, 2*90, 90, 90);g.setColor(color[8]);
			g.fillRect(2*90, 2*90, 90, 90);
			
			g.setColor(Color.lightGray);
			g.fillRect(3*90, 3*90, 90, 90);
			g.setColor(Color.BLACK);
			g.drawString("1", 284, 284);
			g.drawString("2", 314, 284);
			g.drawString("3", 344, 284);
			g.drawString("4", 284, 314);
			g.drawString("5", 314, 314);
			g.drawString("6", 344, 314);
			g.drawString("7", 284, 344);
			g.drawString("8", 314, 344);
			g.drawString("9", 344, 344);
			
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 12; j++) {
					g.setColor(Color.white);
					g.drawLine(i * 30, 0, i * 30, 400);
					g.drawLine(i * 30 + 1, 0, i * 30 + 1, 400);
					g.drawLine(0, j * 30, 400, j * 30);
					g.drawLine(0, j * 30 + 1, 400, j * 30 + 1);
				}
			}
			
		
		}
		
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		Graphics k = getGraphics();
		if (e.isShiftDown()) {
			count = 0;
			
			repaint();
			return;
		}
		int x = e.getX();
		int y = e.getY();
		
		if (x >= 270 && x <= 360 && y >= 270 && y <= 360) {
			int row = y / 30;
			int col = x / 30;
			if(row==9 && col==9)
				l=1;
			else if(row==9 && col==10)
				l=2;
			else if(row==9 && col==11)
				l=3;
			else if(row==10 && col==9)
				l=4;
			else if(row==10 && col==10)
				l=5;
			else if(row==10 && col==11)
				l=6;
			else if(row==11 && col==9)
				l=7;
			else if(row==11 && col==10)
				l=8;
			else if (row==11 && col==11)
				l=9;
			
		
		}
		k.setColor(Color.WHITE);
		k.drawRect(330,90,370,120);
		k.setColor(Color.BLACK);
		k.drawString(""+l, 350, 100);
		x = e.getX();
		y = e.getY();
		if (x >= 0 && x <= 270 && y >= 0 && y <= 270) 
			row = y / 30;
			col = x / 30;
		
		for(int i=0; i<9;i++){
			if (x >= i*90 && x <= (i+1)*90 && y >= i*90 && y <= (i+1)*90) {
				//k.setFont(new Font("serif", Font.BOLD, 10));
				k.setColor(Color.BLACK);
				k.drawString(""+l,row*30+15,col*30+15);
			}
		}
		
		if(row>=0&&row<=90||col>=0&&col<=90)
			taken[row/30][col/30]=true;
		else if(row>=90&&row<=180||col>=0&&col<=90)
			taken1[row/60][col/60]=true;	
		else if(row>=180&&row<=270||col>=0&&col<=90)
			taken2[row/90][col/90]=true;	
		else if(row>=0&&row<=90||col>=90&&col<=180)
			taken3[row/30][col/30]=true;	
		else if(row>=90&&row<=180||col>=90&&col<=180)
			taken4[row/60][col/60]=true;	
		else if(row>=180&&row<=270||col>=90&&col<=180)
			taken5[row/90][col/90]=true;	
		else if(row>=0&&row<=90||col>=180&&col<=270)
			taken6[row/30][col/30]=true;	
		else if(row>=90&&row<=180||col>=180&&col<=270)
			taken7[row/60][col/60]=true;	
		else if(row>=180&&row<=270||col>=180&&col<=270)
			taken8[row/90][col/90]=true;
					
			
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(row>=0&&row<=90||col>=0&&col<=90)
					taken[row/30][col/30]=true;
				else if(row>=90&&row<=180||col>=0&&col<=90)
					taken1[row/60][col/60]=true;	
				else if(row>=180&&row<=270||col>=0&&col<=90)
					taken2[row/90][col/90]=true;	
				else if(row>=0&&row<=90||col>=90&&col<=180)
					taken3[row/30][col/30]=true;	
				else if(row>=90&&row<=180||col>=90&&col<=180)
					taken4[row/60][col/60]=true;	
				else if(row>=180&&row<=270||col>=90&&col<=180)
					taken5[row/90][col/90]=true;	
				else if(row>=0&&row<=90||col>=180&&col<=270)
					taken6[row/30][col/30]=true;	
				else if(row>=90&&row<=180||col>=180&&col<=270)
					taken7[row/60][col/60]=true;	
				else if(row>=180&&row<=270||col>=180&&col<=270)
					taken8[row/90][col/90]=true;
				
				
				
				
				if (taken[i][j] == false) {
					
				
				/*while (count < 17 && taken[row][col] == false) {
					taken[row][col] = true;
					k.setFont(new Font("serif", Font.BOLD, 40));
					k.setColor(Color.red);
					k.drawString("" + count, col * 100 + 40, row * 100 + 60);
				}*/
				}
			}}
		
		k.dispose();
			
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}

