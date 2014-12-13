import java.awt.*;
import java.applet.Applet;

public class redo extends Applet{
	private int fillnum,count1,count2;
	private int [][] board=new int[8][8];
	
	public redo(){
		fillnum=0;
	}
	
	public static void main(String[]args){
		Othello done=new Othello();
	} 
	public void paint(Graphics g){
		g.setColor(Color.pink);
		g.fillRect(0, 0, 400, 400);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[i][j]=(int)(Math.random()*3);
			}
		}
	
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]==1)
					count1++;
				if(board[i][j]==2)
					count2++; 
			}
		}
		g.setColor(Color.yellow);
		g.fillRect(0, 400, 400, 200);
		g.setColor(Color.red);
		if(count1>count2){
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString(" "+count1,110,515);
			g.setFont(new Font("serif",Font.PLAIN,13));
			g.setColor(Color.black);
			g.drawRect(25,450,150,100);
			g.drawString("Winner!", 50, 460);
			g.setColor(Color.red);
			g.drawRect(50,480,50,50);
			g.fillOval(50,480,50,50);
	}
		
		if(count1<count2){
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString(" "+count2,330,515);
			g.setFont(new Font("serif",Font.PLAIN,13));
			g.setColor(Color.black);
			g.drawRect(240,450,150,100);
			g.drawString("Winner!", 300, 460);
			g.setColor(Color.blue);
			g.drawRect(265,480,50,50);
			g.fillOval(265,480,50,50);
		}
		if(count1==count2){
			
			
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString(" "+count2,330,515);
			g.setFont(new Font("serif",Font.PLAIN,13));
			g.setColor(Color.black);
			g.drawRect(240,450,150,100);
			g.drawString("Tie!", 300, 460);
			g.setColor(Color.blue);
			g.drawRect(265,480,50,50);
			g.fillOval(265,480,50,50);
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]==1){
					g.setColor(Color.red);
					g.fillOval(50*i,50*j,50,50);
					g.setColor(Color.black);
				}
				if(board[i][j]==2){
					g.setColor(Color.blue);
					g.fillOval(50*i,50*j,50,50);
					g.setColor(Color.black);
					g.drawArc(50*i+5,50*j+8,10,10,180,20);
					
				}
			}
		}
	}
}	
