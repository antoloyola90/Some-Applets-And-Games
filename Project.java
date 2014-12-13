/*
 * Created on Sep 2, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author anto
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Project {
	public static void main (String [] args)  {
		TextReader keyboard=new TextReader ();
		String name, receiver;
		double cost;
		double paid;
		double change, tax;
		String message;
		
		System.out.print("\n\n\nEnter your name ---> ");
		name=keyboard.readLine ();
		System.out.print ("\n\nEnter the cost of your gift --->" ) ;
		cost = keyboard.readlnDouble ();
		System.out.print ("\n\nEnter the amount paid  --->" );
		paid=keyboard.readlnDouble ();;
		System.out.print ("\n\nwho will recieve this gift   ?");
		receiver=keyboard.readLine ();
		System.out.print ("\n\nEnter a message   ---->");
		message=keyboard.readLine();
		
		tax = cost*0.0825;
		change = paid - cost - tax;
		
		System.out.println ("\n\n\n" + name + ", here is your receipt:");
		System.out.println ("\nAmount tendered:" + Format.right (paid, 10, 2 ) );
		System.out.println ("\ncost           :" + Format.right (cost, 10, 2) );
		System.out.println ("\nTax            :" + Format.right (tax, 10, 2) );
		System.out.println ("\n--------------------------------");
		System.out.println ("\nChange         :" + Format.right (change, 10, 2 ) );
		
		System.out.println ("\n\n\n\nDear" + receiver + ",");
		System.out.println ("\n" + message );
		System.out.println ("\n Love, " + name + "\n\n");
	
	
	
	
	
	}
}
