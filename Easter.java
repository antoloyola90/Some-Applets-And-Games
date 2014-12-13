public class Easter {
	private int year, a, b, c, d, e, f, g, h, i, k, r, m, n, p;
	
	public Easter ()	{
	}
	
	public static void main(String[] args) {
		Easter finddate=new Easter ();
		finddate.RunLoop();
	}
	
	public void RunLoop ()	{

		do {
			GetInput();
			if (year<5000 && year>=1583){	
				Calculate();
				PrintDate();
			}	
			
		} while (year != 1583);
		System.out.println("\n\nGoodbye!\n\n");
	}
	
	public void GetInput ()	{
			TextReader read=new TextReader ();
			System.out.print("Enter the year (from 1583 to 5000, 1583 to end)->");
			year=read.readInt();
	}
	
	public void Calculate ()	{

		a=year%19;
		b=year/100;
		c=year%100;
		d=b/4;
		e=b%4;
		f=(b+8)/25;
		g=(b-f+1)/3;
		h=(19*a+b-d-g+15)%30;
		i=c/4;
		k=c%4;
		r=(32+2*e+2*i-h-k)%7;
		m=(a+11*h+22*r)/451;
		n=(h+r-7*m+114)/31;
		p=(h+r-7*m+114)%31;
		
	}
	
	public void PrintDate()	{
		switch (n)	{
			case 1:System.out.println("Easter is on January"+ " "+(p+1)+", "+year); break;
			case 2:System.out.println("Easter is on February"+ " "+(p+1)+", "+year); break;
			case 3:System.out.println("Easter is on March"+ " "+(p+1)+", "+year); break;
			case 4:System.out.println("Easter is on April"+ " "+(p+1)+", "+year); break;
			case 5:System.out.println("Easter is on May"+ " "+(p+1)+", "+year); break;
			case 6:System.out.println("Easter is on June"+ " "+(p+1)+", "+year); break;
			case 7:System.out.println("Easter is on July"+ " "+(p+1)+", "+year); break;
			case 8:System.out.println("Easter is on August"+ " "+(p+1)+", "+year); break;
			case 9:System.out.println("Easter is on September"+ " "+(p+1)+", "+year); break;
			case 10:System.out.println("Easter is on October"+ " "+(p+1)+", "+year); break;
			case 11:System.out.println("Easter is on November"+ " "+(p+1)+", "+year); break;
			case 12:System.out.println("Easter is on December"+ " "+(p+1)+", "+year); break;
		}
		
	}
}