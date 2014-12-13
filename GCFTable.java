//	Anto Loyola		2/9/05
//	GCFTable.java
//	This program asks you for the length and width dimensions of a greatest common factor table and it
//	uses this information to print out the table in the form of a multiplication table but instead of
//	products it prints the GCF(greatest common factor.

public class GCFTable   {

	private int [][] table;					//  The 2D array for the gcf table.

	private int maxrow, maxcol;				//  The number of rows and columns,
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

	public void PromptUser ( )   {
		
		do{
			System.out.print("\nEnter the rows (1-30)		->");
			maxrow=DealWithInput();
		}while(maxrow<1||maxrow>30);
		do{
			System.out.print("\nEnter the columns (1-18)	->");
			maxcol=DealWithInput();
		}while(maxcol<1||maxcol>18);
	}
	
	public int DealWithInput(){
		TextReader console=new TextReader();
		String input=console.readLine();
		if(input.length()>2||input.length()<1)
			return -1;
		else if(input.length()==1)
			return ((int)input.charAt(0)-48);
		else if(input.length()==2)
			return (((int)(input.charAt(0)-48)*10)+(int)input.charAt(1)-48);
		return -1;
	}
	public void FillWithGCFs ( )   {
		table=new int[maxrow+1][maxcol+1];
		for(int i=1;i<table.length;i++)
			for(int j=1;j<table[i].length;j++)
				table[i][j]=GCF(i,j);
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
		System.out.print( "\n\n   ");
		//for(int i=1;i<table[0].length;i++)
			//System.out.print(Format.right(i,4));
		System.out.print("    ");
		for(int i=1;i<table[0].length;i++)
			System.out.print(Format.right(i,4));
		System.out.println("\n");
		System.out.print("      ");
		for(int i=1;i<table[0].length;i++)
		//System.out.print("   _");
			System.out.print(" _ _");
		System.out.println("\n");
		
		for(int i=1;i<table.length;i++){
		
			System.out.print(Format.right(i,4));
			System.out.print("  |");
			for(int j=1;j<table[i].length;j++)
				System.out.print(Format.right(table[i][j],4));
			System.out.println();
		}
	}
}

