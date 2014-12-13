public class Janet1  {
	private int [][] table;
	private int max, start;
	
	public Janet1() {
		table = new int[6][7];
		max=start=0;
	}
	
	public static void main (String [] args) {
	 	Calendar program = new Calendar();
		program.GetNumberOfDays();
		program.GetStartDay();
		program.SetCalendar();
		program.PrintCalendar();
	}
	
	public void GetNumberOfDays() {
		TextReader console = new TextReader();
		do {
			System.out.print("\nEnter the number of days in the month -> ");
			max = console.readlnInt();
			
		} 
		while( max < 28 || max > 31 );
		
	}
	public void GetStartDay() {
		TextReader console = new TextReader();
		do {
			System.out.print("\n\n1: Sunday,    2: Monday,  ");
			System.out.print("3: Tuesday,   4: Wednesday, \n");
			System.out.print("5: Thursday,  6: Friday,  7: Saturday\n\n");
			System.out.print("Enter the day to start the month(1-7) -> " );
			start = console.readlnInt();
		}
		 while (start < 1 || start > 7 );
	}
	public void SetCalendar() {
		int docounter = 1;
		for (int column = start-1; column < table[0].length; column++)   {
			table[0][column] = docounter;
			docounter++;
		}
		for (int row = 1; row < table.length; row++)   {
			for (int column = 0; column < table[row].length; column++)   
				if(docounter <=max) {
					table[row][column] = docounter;
					docounter++;
		}
	}
}
	public void PrintCalendar() {
		System.out.println("\nSun Mon Tue Wed Thu Fri Sat\n");
		
		for (int row = 0; row < table.length; row++)   {
			for (int col = 0; col < table[row].length; col++)
			
			if(table[row][col] == 0) {
				System.out.print("    ");
			}
			else	
			System.out.print ( Format.left ( table[row][col], 4 )  );
				System.out.println ( );
		}
	}
}		
/*public class GCFTable   {

private int [][] table;					//  The 2D array for the gcf table.

private int maxrow, maxcol, number;				//  The number of rows and columns,
							//  to be chosen by the user.

public GCFTable ( )  {					//  The constructor.
	maxrow = maxcol = 0;
}

public static void main ( String [] args )   {
	GCFTable gcf = new GCFTable ( );
	gcf.PromptUser ( );				//  Prompts the user for the number
							//  of row and columns.
	gcf.FillWithGCFs ( );				//  Sets the dimensions of the array
							//  and fills it with gcf's.
	gcf.PrintTable ( );				//  Prints the table.
}
/*public int GetNumber(String message){
		TextReader console=new TextReader();
	while(true){
			System.out.print(message);
			String c=console.readLine();
			if (c!=null&&c.length()<=2&&c.length()>0) {
				/*char ch=c.charAt(0);
			char dh=c.charAt(1);
			int cha=(int)((ch+dh)-'0');
				if (cha>=1 && cha<=30)
 					return cha;
			
		int ch=((c.charAt(0))-'0');
		int dh=((c.charAt(1))-'0');
		number=ch+dh;}
		return number; 

		}

	}*/

/*	public void PromptUser ( )   {
	TextReader console=new TextReader();
	boolean che=true;
	while(che){
	System.out.print("Enter the number of rows (1-30)	-> ");
	maxrow=console.readInt();
	if(maxrow<31&&maxrow>0)
		che=!che;
	
	else
		che=true;
	}
	boolean check=true;
	while(check){
	System.out.print("Enter the number of columns (1-18)	-> ");
	maxcol=console.readInt();
	if(maxcol<19&&maxcol>0)
		check=!check;
	
	else
		check=true;
	}
	//maxrow=GetNumber("Enter the number of rows (1-30)	-> ");
	//maxcol=GetNumber("Enter the number of columns (1-18)	-> ");
}

public void FillWithGCFs ( )   {
	for(int i=1;i<=maxrow;i++){
		for(int j=1;j<=maxcol;j++){
			table[i][j]=i*j;
		}
	}
	for(int i=1;i<=maxrow;i++){
		for(int j=1;j<=maxcol;j++){
			table[i][j]=GCF(i,j);
			//table[i][j]=table[maxrow][maxcol];
		
		System.out.print(table[i][j]);}
	}
}

public int GCF ( int x, int y )  {
	int r = x % y;
	
	while ( r != 0 )   {
		x = y;
		y = r;
		r = x % y;
	}
	return y;
}

public void PrintTable ( )   {
	//table[][]=table[maxrow][maxcol];
	System.out.print("   |");
	System.out.print("---+");
	for (int i=1;i<=maxrow;i++){
			System.out.print("   "+i);
		System.out.print("----");
	}
		for(int j=1;j<=maxcol;j++)
				System.out.println(" "+j+" |");
			/*for(int j=1;j<=6;j++){
				System.out.print("| ");
				if (j<6)
 					System.out.print(table[i-1][j-1]);
				else
 					System.out.print(' ');
				System.out.print(' ');
			}
			System.out.println();
		}
		for(int j=1;j<=5;j++)
			System.out.print("----");*/
		//}


//}*/