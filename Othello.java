import java.awt.*;
import java.applet.Applet;

public class Othello extends Applet{
	private int fillnum,count1,count2;
	private int [][] board=new int[8][8];
	
	public Othello(){
		fillnum=0;
	}
	
	public static void main(String[]args){
		Othello done=new Othello();
		//done.FillBoard();
	} 
	public void paint(Graphics g){
		//for(int b=0;b<290;b++){
		g.setColor(Color.pink);
		g.fillRect(0, 0, 400, 400);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[i][j]=(int)(Math.random()*3);
				//System.out.print(board);
			}
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(j%2==0&&i%2==0){
					g.setColor(Color.green);
					g.fillRect(i*50,j*50,50,50);
				}
				if(j%2==1&&i%2==1){
					g.setColor(Color.green);
					g.fillRect(i*50,j*50,50,50);
				}
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
		//System.out.print("  Red    "+count1+"    Blue    "+count2);
		g.setColor(Color.yellow);
		g.fillRect(0, 400, 400, 200);
		//count2+=50;
		g.setColor(Color.black);
		//g.drawString("  Red "+count1+"   Blue     "+count2,70,480);
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
			g.setColor(Color.black);
			g.drawLine(53,495,96,495);
			g.drawLine(96,495,57,522);
			g.drawLine(57,522,75,480);
			g.drawLine(75,480,92,522);
			g.drawLine(92,522,53,495);
			
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString(" "+count2,330,515);
			g.setFont(new Font("serif",Font.PLAIN,13));
			g.setColor(Color.black);
			g.drawRect(240,450,150,100);
			g.drawString("Loser!", 300, 460);
			g.setColor(Color.blue);
			g.drawRect(265,480,50,50);
			g.fillOval(265,480,50,50);
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
			
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString(" "+count1,110,515);
			g.setFont(new Font("serif",Font.PLAIN,13));
			g.setColor(Color.black);
			g.drawRect(25,450,150,100);
			g.drawString("Loser!", 50, 460);
			
			g.setColor(Color.red);
			g.drawRect(50,480,50,50);
			g.fillOval(50,480,50,50);
			g.setColor(Color.black);
			g.drawLine(53,495,96,495);
			g.drawLine(96,495,57,522);
			g.drawLine(57,522,75,480);
			g.drawLine(75,480,92,522);
			g.drawLine(92,522,53,495);
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
			
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString(" "+count1,110,515);
			g.setFont(new Font("serif",Font.PLAIN,13));
			g.setColor(Color.black);
			g.drawRect(25,450,150,100);
			g.drawString("Tie!", 50, 460);
			
			g.setColor(Color.red);
			g.drawRect(50,480,50,50);
			g.fillOval(50,480,50,50);
			g.setColor(Color.black);
			g.drawLine(53,495,96,495);
			g.drawLine(96,495,57,522);
			g.drawLine(57,522,75,480);
			g.drawLine(75,480,92,522);
			g.drawLine(92,522,53,495);
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]==1){
					//g.setColor(Color.black);
					//g.fillArc(50*i,50*j,5,5,0,120);
					g.setColor(Color.red);
					g.fillOval(50*i,50*j,50,50);
					g.setColor(Color.black);
					g.drawLine(50*i+3,50*j+15,50*i+46,50*j+15);
					g.drawLine(50*i+46,50*j+15,50*i+7,50*j+42);
					g.drawLine(50*i+7,50*j+42,50*i+25,50*j);
					g.drawLine(50*i+25,50*j,50*i+42,50*j+42);
					g.drawLine(50*i+42,50*j+42,50*i+3,50*j+15);
				}
				if(board[i][j]==2){
					//g.setColor(Color.black);
					//g.drawRect(50*i,50*j,49,49);
					g.setColor(Color.blue);
					g.fillOval(50*i,50*j,50,50);
					g.setColor(Color.black);
					g.drawArc(50*i+5,50*j+8,10,10,180,20);
					
				}
				if(board[i][j]==0){
					g.setColor(Color.black);
					g.drawString("Empty",50*i+9,50*j+25);
				}
			}
		}
		for(int i=1;i<9;i++){
			//g.setColor(Color.black);
			Color m=Color.getHSBColor( (float)Math.random(), 0.6F, 0.6F );
			g.setColor(m);
			g.drawLine(0,i*50,400,i*50);
			g.drawLine(i*50,0,i*50,400);
			g.drawLine(0,i*50+1,400,i*50+1);
			g.drawLine(i*50+1,0,i*50+1,400);
			
		}
		
		
		//}
	}
}	
