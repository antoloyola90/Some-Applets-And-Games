public class Pascal {
	private int input;
	

	public Pascal() {
	}

	public static void main(String[] args) {
		Pascal table = new Pascal();
		table.RunLoop();
	}

	public void RunLoop() {
		do {
			GetInfo();
			if (input!=0)
				PrintTable();
		} while (input != 0);
		System.out.println("\n\nGoodbye!\n\n");
	}

	public void GetInfo() {
		do {
			TextReader key=new TextReader();
			System.out.print("Enter the max int value for your table (1 - 15, 0 to exit) ->");// read input
			input=key.readInt();
			if (input<0 || input>15) 
				System.out.println("Enter some valid input!");
			
			
		} while (input < 0 || input > 15);
	}
	
		public long Factorial (long x){
			long f=1;
			for (long i=2; i<=x; i++){
				f=f*i;
			}
			return f;
			
		}
			
		
	
	public void PrintTable() {
		System.out.println();
		for (int n = 0; n <= input; n++) { // This exterior for loop controls
										   // the number of rows.
			for (int i = 0; i <= n; i++) { // This interior for loop controls
										   // the values in each row.
				long f=Factorial(n)/(Factorial(i)*Factorial(n-i));
				System.out.print(""+f+"   ");
			}
			
			System.out.println(); // This will end each row and move to the next
								  // line.
			
		}
	}
}
