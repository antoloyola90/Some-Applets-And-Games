//Anto Loyola		2/8/05
//Count.java
//
//
//

public class Count   {
	private TextReader kbd;
	private int [] myArray;
	private Sorting quadsort;
	
	public Count ( )   {
		kbd = new TextReader ( );
		quadsort = new Sorting ( );
	}
	
	public static void main ( String[] args )   {
		Count doSorts = new Count ( );
		doSorts.sortMenu ( );
	}
	
	public void sortMenu()   {
		String choice, print;
		
		do   {
			System.out.println ( "\nSorting algorithm menu\n" );
			System.out.println ( "(1) Bubble sort" );
			System.out.println ( "(2) Selection sort" );
			System.out.println ( "(3) Insertion sort" );
			System.out.println ( "(Q) Quit\n" );
			System.out.print ( "Choice ---> " );
			choice = kbd.readLine ( ) + " ";
			if ( '1' <= choice.charAt(0) && choice.charAt(0) <= '3' )   {
				System.out.print ( "\nHow many numbers do you wish to generate? " 
				);
				int numInts = kbd.readlnInt ( );
				System.out.print ( "Largest integer to generate? " );
				int largestInt = kbd.readlnInt ( );
				fillArray ( numInts, largestInt );
				
				quadsort.setStepCount ( 0 );
				
				switch ( choice.charAt(0) )   {
				case '1':       quadsort.bubbleSort ( myArray );        break;
				case '2':       quadsort.selectionSort ( myArray );     break;
				case '3':       quadsort.insertionSort ( myArray );     break;
				}
				System.out.print ( "\nPrint list to screen (y/n)? " );
				print = kbd.readLine ( );
				if ( print.charAt(0) == 'y' || print.charAt(0) == 'Y' )
					screenOutput();
				System.out.println ( "\n# steps = " + quadsort.getStepCount ( ) );
				System.out.print ( "\nHit return to continue" );
				kbd.readLine ( );
			}
		} while ( choice.charAt(0) != 'Q' && choice.charAt(0) != 'q' );
	}
	
	private void fillArray ( int numInts, int largestInt )   {
		myArray = new int[numInts];
		
		for (int loop = 0; loop < myArray.length; loop++)
			myArray[loop] = (int)( Math.random ( ) * (largestInt) + 1 );
	}
	
	private void screenOutput ( )   {
		for (int loop = 0; loop < myArray.length; loop++)   {
			if (loop % 10 == 0)
				System.out.println ( );
			System.out.print ( Format.right ( myArray[loop], 6 ) );
		}
		System.out.println ( );
	}
}

class Sorting   {
	private long steps;
	
	public Sorting ( )   {
		steps = 0;
	}
	
	public void bubbleSort ( int [] list )   {
		steps++;							//this is for int outer=0;
		for (int outer = 0; outer < list.length - 1; outer++)   {
			steps++;						//each time that the outer<list.length-1 is true;
			steps++;						//this is for outer++;
			steps++;						//counting int inner=0;
			for (int inner = 0; inner < list.length-outer-1; inner++)   {
				steps++;					//for when the boolean expression is true;
				steps++;					//for the inner++;
				steps++;					//for the boolean in the if.
				if (list[inner] > list[inner + 1])   {
					steps+=3;				//for the 3 statements inside the if.
					int temp = list[inner];
					list[inner] = list[inner + 1];
					list[inner + 1] = temp;
				}
				
			}
			steps++;						//When the boolean expression for the interior for loop is true; 
		}
		steps++;							//when the boolean expression for the exterior loop is false.
		// Replace these lines with your code
		System.out.println ( );
		System.out.println ( "Bubble Sort" );
		System.out.println ( );
	}
	
	public void selectionSort ( int [] list )   {
		int min, temp;
		steps++;
		
		for (int outer = 0; outer < list.length - 1; outer++){
			steps+=4;
			min = outer;
			for (int inner = outer + 1; inner < list.length; inner++){
				steps+=3;
				if (list[inner] < list[min]){
					steps++;
					min = inner;
				}
			}
			steps++;
			
			temp = list[outer];
			list[outer] = list[min];
			list[min] = temp;
		}
		steps++;
		/*int 
		 for (int outer = 0;outer < list.length - 1; outer++)   {
		 min = ;
		 for (int inner = ;inner < list.length-outer-1; inner++         )   {
		 if (  )   {
		 min = ;
		 }
		 }
		 
		 
		 
		 
		 }
		 // Replace these lines with your code
		  System.out.println ( );
		  System.out.println ( "Selection Sort" );
		  System.out.println ( );*/
	}
	
	public void insertionSort ( int [] list )   {
		steps++; 
		for (int outer = 1; outer < list.length; outer++){
			steps+=4;
		    int position = outer;
		    int key = list[position];
			// Shift larger values to the right
		    steps+=2;
		    while (position > 0 && list[position - 1] > key){
		    	steps+=2;
		    	list[position] = list[position - 1];
		    	position--;
		    }
		    steps++;
		    list[position] = key;
		 }

		//		for (int outer = 1;                  )   {
		//			int position = ;
		//			int key = ;
		//  
		//			// Shift larger values to the right
		//			while ( )   {
		//				
		//				
		//			}
		//			list[position] = ;
		//		}
		
		// Replace these lines with your code
		System.out.println ( );
		System.out.println ( "Insertion Sort" );
		System.out.println ( );
	}
	
	public long getStepCount ( )   {
		return steps;
	}
	
	public void setStepCount ( int stepCount )   {
		steps = stepCount;
	}
}


