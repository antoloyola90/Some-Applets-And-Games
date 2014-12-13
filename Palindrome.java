public class Palindrome {
	private int number, reversal;
	
	public Palindrome ( ) {
	}
	public static void main ( String [] args ) {
		Palindrome pal = new Palindrome ( );
		pal.GetNumber ( );
		pal.FindPalindrome ( );
		
	}
	
	public void GetNumber ( ) {
		TextReader keyboard=new TextReader ();
		System.out.print("Enter an integer (1-1000) ->");
		number=keyboard.readInt ();
		System.out.print("\n");
	}
	
	public void FindPalindrome ( ) {

		if ( number >= 1 && number <= 1000 ) {
			while ( !APalindrome() && number < 1000000000 ) {
				int x=number;
				int digit=0, mult=1;
				int i=1;
				while (x>0)	{
					x=x/10;
					digit++;
					mult=mult*10;
					i++;
				}
				mult=mult/10;
				
				x=number;
				
				i=1;
				int reverse=0;
				while (i<=digit){
					int mod=x%10;
					reverse=reverse+mod*mult;
					x=x/10;
					mult=mult/10;
					i++;
				}
				System.out.println(number+" + "+reverse+" = "+(number+reverse));
				number=number+reverse;
				
				
			}
			if (APalindrome())
				System.out.print("Yes!!, the palindrome is: "+number);
		
			if (number>1000000000)	{
				
				System.out.print("\nNo palindrome, max exceeded");
				System.out.print("\n");
			}
		}
		else{
	
				System.out.print("\nEnter a value from 1 to 1000!");
				System.out.print("\n");

		}
	}
			
	
	public boolean APalindrome ( ) {
		int numbercopy = number, count;
		boolean check = true;
		while ( numbercopy != 0 ) {
			count = 0;
			int firstdigit = numbercopy / 10;
			int lastdigit = numbercopy % 10;
			if ( firstdigit != 0 ) {
				while ( firstdigit > 9 ) {
					count++;
					firstdigit /= 10;
				}
				if ( firstdigit != lastdigit ) {
					check = false;
					numbercopy = 0;
				}
				else
					numbercopy = (numbercopy - (firstdigit *
							(int)Math.pow(10,count+1) ) ) / 10;
			}
			else
				numbercopy = 0;
		}
		return check;
		}
	}	