public class Movie {
	private double tax, amount, camount, bamount;
	private int child, adult, day;
	
	public Movie () {
	}

	public static void main(String[] args) {
		Movie dot=new Movie();
		dot.GetInfo();
		dot.DoInfo();
		dot.PrintInfo();
	}
	
	public void GetInfo ()	{ 
		TextReader key=new TextReader();
		System.out.println("1) Monday");
		System.out.println("2) Tuesday");
		System.out.println("2) Wednesday");
		System.out.println("4) Thursday");
		System.out.println("5) Friday");
		System.out.println("6) Saturday");
		System.out.println("7) Sunday");
		System.out.print("\nEnter the day that you are buying the tickets			  ->");
		day=key.readInt();
		System.out.print("Enter the number of adult tickets that you want to buy 	          ->");
		adult=key.readInt();
		System.out.print("Enter the number of children tickets that you want to buy         ->");
		child=key.readInt();
	}
	public void DoInfo ()	{
		switch (day) {
			case 1:amount=(10-(10*0.05));
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
			case 2:amount=(10-(10*0.1));
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
			case 3:amount=(10-(10*0.15));	
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
			case 4:amount=(10-(10*0.2));
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
			case 5:amount=(10-(10*0.25));
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
			case 6:amount=(10);
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
			case 7:amount=(10);
				bamount=(adult*amount);
				camount=(child*(amount-amount*0.50)); break;
		}
	
			
	
		
	}
	public void PrintInfo ()	{
		System.out.println("\nNumber of adults                            ->  "+adult);
		System.out.println("Number of children                          ->  "+child);
		if (day==1)
			System.out.println("The day that you are buying your tickets    -> Monday");
		if (day==2)
			System.out.println("The day that you are buying your tickets    -> Tuesday");
		if (day==3)
			System.out.println("The day that you are buying your tickets    -> Wednesday");
		if (day==4)
			System.out.println("The day that you are buying your tickets    -> Thursday");
		if (day==5)
			System.out.println("The day that you are buying your tickets " +
					"   -> Friday");
		if (day==6)
			System.out.println("The day that you are buying your tickets    -> Saturday");
		if (day==7)
			System.out.println("The day that you are buying your tickets    -> Sunday");
		System.out.println("Amount for tickets for adults               -> $"+bamount);
		System.out.println("Amount for tickets for children             -> $"+camount);
		System.out.println("Total amount spent                          -> $"+(bamount+camount));
	}
}

