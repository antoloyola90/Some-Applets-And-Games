/*
 * Created on Aug 26, 2004
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
public class Data2 {

	public static void main(String[] args) {
		int meal_1 = 10, meal_2 = 8;
		double taxrate=0.0825;
		double movie=8.50;
		double tip = 5.25;
		double totalcost = (meal_1 + meal_2)*(1.0 + taxrate) + (2 * movie) + tip;
		String dollar = "$"; 
		System.out.println(dollar + totalcost);
		
		
	}
}
