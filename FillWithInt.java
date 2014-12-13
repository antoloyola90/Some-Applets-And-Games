public class FillWithInt   {
	private int counter, max, number;

	public FillWithInt ( )  {
		counter = max = number = 0;
	}

	public static void main ( String [] args )  {
		FillWithInt fill = new FillWithInt ( );
		fill.PlaceNumbers ( );
	}

	public void PlaceNumbers ( )  {
		TextWriter outFile = new TextWriter ( "numbers.txt" );
		max = (int)(Math.random() * 501) + 100;
		while ( counter < max )  {
			number = (int)(Math.random() * 100) + 1;
			System.out.print ( Format.left ( number, 5 ) );
			outFile.print ( Format.left ( number, 5 ) );
			counter++;
			if ( counter % 16 == 0 )   {
				System.out.println ( "\n" );
				outFile.println ( "\n" );
			}
		}
		System.out.println ( );
		outFile.println ( );
		outFile.close ( );
	}
}

