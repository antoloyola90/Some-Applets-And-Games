import java.awt.*;
import java.applet.Applet;

public class Picture extends Applet {
	private int number;
	private Color myColor1, myColor2,backcolor;
	public Picture(){
		number=0;
		
	}
	public static void main(String []args)	{
		Picture done=new Picture();
		//done.Figure();
	}
	public void paint (Graphics f) {
		number=(int)(Math.random()*2)+1;
		if(number==1){
			f.setColor(Color.GREEN);
			f.fillRect(0,0,600,500);
		}
		else{
			f.setColor(Color.YELLOW);
			f.fillRect(0,0,600,500);
		}
		
		for(int i=0;i<15;i++){
			int num=(int)(Math.random()*2)+1;
			switch(num){
			case 1:
				f.drawOval(100, 100, 50, 50);
				f.drawLine(125, 150, 125, 300);
				f.drawArc(115, 300, 20, 125, 0, 200);
				myColor2 = Color.getHSBColor( (float)Math.random(), 1.0F, 1.0F );
				f.setColor(myColor2);
				f.fillArc(115, 200, 20, 125, 0, 2000);
				f.drawLine(123, 250, 80, 100);
				f.drawLine(130, 250, 200, 100);
				f.drawString("U     U", 110,120);
				f.drawString("V", 123,132);
				f.drawRoundRect(123, 140, 5, 3, 2, 2);
				f.drawString("Hi, Java is so Cool!", 300,280);break;
				
				
			case 2:
				
				f.drawOval(100, 100, 50, 50);
				f.drawLine(125, 150, 125, 300);
				f.drawArc(115, 300, 20, 125, 0, 200);
				myColor2 = Color.getHSBColor( (float)Math.random(), 1.0F, 1.0F );
				f.setColor(myColor2);
				f.fillArc(115, 200, 20, 125, 0, 2000);
				f.drawLine(123, 250, 80, 100);
				f.drawLine(130, 250, 200, 100);
				f.drawString("O     O", 110,120);
				f.drawString("#", 123,132);
				f.drawRoundRect(123, 140, 5, 3, 2, 2);
				f.drawString("Hi, Java is so Cool!", 300,280);break;
			}
			f.drawString("Hi, Java is so Cool!", (int)(Math.random()*200)+200,(int)(Math.random()*100)+180);
			f.fill3DRect((int)(Math.random()*200)+200,(int)(Math.random()*100)+190,(int)(Math.random()*20)+1,
					(int)(Math.random()*20)+1,true);
			f.drawString("Whee!", (int)(Math.random()*200)+200,(int)(Math.random()*0)+60);
			f.drawString("Whoo!", (int)(Math.random()*200)+200,(int)(Math.random()*300)+180);
			}
		
	}}

