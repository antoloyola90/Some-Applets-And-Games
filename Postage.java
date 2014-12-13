
public class Postage {
	public static void main ( String [] args ) {
		Postage sendthis = new Postage ( );
		sendthis.GetData ( );
		sendthis.CalculateCost ( );
		sendthis.PrintInfo ( );
}

	public TextReader keyboard=new TextReader ();
	private int mailclass;
	private int weight;
	private double cost;
	
	public Postage ()	{
		
	}
	
	public void GetData (){
		System.out.println("Hello, and welcome to the US Post Office.");
		System.out.println("\n  (1) First class, domestic");
		System.out.println("  (2) Postcards, domestic");		
		System.out.println("  (3) Book rate)\n");
		System.out.print("Using the menu above, please enter the category of your postage	->");
		mailclass=keyboard.readInt();
		if (mailclass==1){
			
			System.out.print("Enter the weight, in ounces, of your letter (an integer)	->");
			weight=keyboard.readInt();
		}
		
		else if (mailclass==3){
			
			System.out.print("Enter the weight, in ounces, of your letter (an integer)	->");
			weight=keyboard.readInt();
		}
		else if (mailclass<1 && mailclass>3){
			System.out.println("\nPlease enter a valid postage class!");
		}
	}
	public void CalculateCost () {
		if (mailclass==1)	
			cost = 0.34+(weight-1)*0.21;
		else if (mailclass==2)
			cost=0.20;
		else if (mailclass==3){
			cost=1.24;
			if (weight>7)
				cost=cost+(weight-7)*0.29+6*0.43;
			else
				cost=cost+(weight-1)*0.43;
		}
	}
	
	public void PrintInfo()	{
		if (mailclass==1){
			System.out.println("\nYour postage class:      				   First class, domestic");
			System.out.println("Weight:	                   	 "+Format.right(weight,30,0)+" ounces");
			System.out.println("Charge:		                $"+Format.right(cost,30,2));
		}
		else if (mailclass==2)	{
			System.out.println("\nYour postage class:         Postcards, domestic");
			System.out.println("Weight:				--");
			System.out.println("Charge:		                    $"+Format.right(cost,30,2));
		}
		
		else if (mailclass==3)	{
			System.out.println("\nYour postage class:         Book Rate");
			System.out.println("Weight:		"+weight+" pounds");
			System.out.println("Charge:		$"+Format.right(cost,0,2));
		}
		else if (mailclass<1 && mailclass>3)
			System.out.print("\nPlease enter a valid postage class!");
		
		
		System.out.println("\n");
		System.out.print("Have a nice day!");
		System.out.println("\n\n");
	}
}


