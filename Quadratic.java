//Anto Loyola        9/10/04
//Quadratic.java
//This program is about inputing different values for the coefficients 
//a,b,c in the quadratic formula and asking the computer to figure out the value 
//of x.  

public class Quadratic {
	public static void main (String [] args)  {
		TextReader keyboard=new TextReader ();
		double a, b, c, x, onex,twox;
		
		System.out.print ( "Input the value of coefficient a ----> ");
		a = keyboard.readDouble ();
		System.out.print( "Input the value of coefficient b ----> ");
		b = keyboard.readDouble ();
		System.out.print( "Input the value of coefficient c ----> ");
		c = keyboard.readDouble ();
		x =(Math.sqrt(Math.pow (b, 2) - 4*a*c));
		onex = ( -b+ x)/(2*a);
		twox = (-b - x)/(2*a);
		System.out.println (onex);
		System.out.println (twox);
		
		
	}
}
