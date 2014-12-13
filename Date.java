public class Date {
	public static void main (String [] args)  {
		TextReader keyboard=new TextReader ();
		String date;
		double entree;
		double beverage;
		double movie;
		double tax, mtax, total, mtotal, tip, thetotal;
		String message;
		System.out.print("Enter the cost of a single entree            -> $ " );
		entree = keyboard.readlnDouble ();
		System.out.print("Enter the cost of a single beverage          -> $ " );
 		beverage = keyboard.readlnDouble ();
		System.out.print("Enter the cost of a single movie ticket      -> $ " );
		movie = keyboard.readlnDouble ();
		
		entree = entree * 2;
		beverage = beverage * 2;
		movie = (movie * 2);
		tax = (entree+ beverage) * 0.0825;
		tip = (entree + beverage + tax) * 0.15;
		mtax = movie * 0.0825;
		total = entree + beverage + tax + tip; 
		mtotal = movie + mtax;
		thetotal = (total + mtotal)/2;  
		System.out.println("Entree subtotal=              $" + Format.right (entree, 0, 2));
		System.out.println("Beverage subtotal=            $" + Format.right (beverage, 0, 2));
		System.out.println("Tax=                          $" + Format.right (tax, 0, 2));
		System.out.println("Tip=                          $" + Format.right (tip, 0, 2));
		System.out.println("Meal Total=                   $" + Format.right (total, 0, 2));
		System.out.println("Movie=                        $" + Format.right (movie, 0, 2));
		System.out.println("Tax=                          $" + Format.right (mtax, 0, 2));
		System.out.println("Movie Total=                  $" + Format.right (mtotal, 0, 2));
		System.out.println("You spent $"+thetotal+"on your date!" );
	
	}
}
