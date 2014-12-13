public class FindDistance {
	public static void main ( String [] args ) {
	TextReader input = new TextReader ( );
	double xone, yone, xtwo, ytwo;
	System.out.print ( "\n\n\nEnter x1 -> " );
	xone = input.readlnDouble ( );
	System.out.print ( "\nEnter y1 -> " );
	yone = input.readlnDouble ( );
	System.out.print ( "\nEnter x2 -> " );
	xtwo = input.readlnDouble ( );
	System.out.print ( "\nEnter y2 -> " );
	ytwo = input.readlnDouble ( );
	Distance inputdist = new Distance ( xone, yone, xtwo, ytwo );
	System.out.println ( "\n\n" );
	inputdist.DisplayPoints ( );
	System.out.println ( "\n\nThe vertical distance is : " +
	Format.right ( inputdist.Vertical ( ), 10, 2 ) );
	System.out.println ( "\nThe horizontal distance is: " +
	Format.right ( inputdist.Horizontal ( ), 10, 2 ) );
	inputdist.ShowDistance ( );
	}
	}


