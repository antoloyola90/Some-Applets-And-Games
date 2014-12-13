/*
 * Created on Sep 9, 2004
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
public class Psychic {

	public static void main(String[] args) {
		TextReader literate = new TextReader ();
		System.out.println ("Please enter your age.");
		int age = literate.readInt();
		System.out.println ("Please enter your birth month and day as a decimal" + "For instance 12-30 is 12.30");
		double born = literate.readDouble();
//		int mathAnswer = 100-age%6+born /(int)(*****);
		System.out.println ("I predict you will live well beyond your" + age + "years");
//		System.out.println ("You will live to be" + mathAnswer);		
//		System.out.println

	}
}
