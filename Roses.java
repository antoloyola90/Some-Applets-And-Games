public class Roses {
	private int number, count=1;
	
	public Roses (){
	}
	
	public static void main(String[] args) {
		Roses find=new Roses();
		find.GetInfo();
		find.DoLoop();
		find.PrintInfo();
	}
	
	public void GetInfo()	{
		TextReader read=new TextReader ();
		System.out.print("Enter Roses ->");
		number=read.readInt();	
	}
	public void DoLoop()	{
		if (number>0 && number<16){
			char a=65, b=66, c=67, d=68, e=69, f=70, g=71, h=71, i=72, j=73, k=74, l=75, m=76, n=77, o=78;
			switch (count)	{
				case 0:count++;
				case 1:System.out.println(Format.right(a,0, 30));
				case 3:System.out.println((b)+" "+(b));
				
			}
		}
	}
	public void PrintInfo()	{
		
	}
	
}
