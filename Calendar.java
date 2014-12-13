//	Anto Loyola		1/24/05
//	Calendar.java
//	This program asks you to enter the number of days in a month and the day of the week it starts. Then it uses a 
//	two-D array of 6x7 to print out a calendar according to the information you entered.  


public class Calendar	{
	private int[][]table;
	private int max, start;
	
	
	public Calendar()	{
		table=new int[6][7];
		max=start=0;
	}
	
	public static void main (String[]args)	{
		Calendar program=new Calendar();
		program.GetNumberOfDays();
		program.GetStartDay();
		program.SetCalendar();
		program.PrintCalendar();
	}
	
	public void GetNumberOfDays()	{
		TextReader console=new TextReader();
		do{
			System.out.print("\nEnter the number of days in the month->");
			max=console.readlnInt();
		}while(max<28||max>31);
	}
	
	public void GetStartDay()	{
		TextReader console=new TextReader();
		do{
			System.out.print("\n\n  1:Sunday,	2:Monday, ");
			System.out.print("  3: Tuesday,     4:Wednesday, \n");
			System.out.print("  5: Thursday,     6:Friday,   7:Saturday\n\n ");  
			System.out.print("\nEnter the day to start the month(1-7)->");
			start=console.readlnInt();
		}while(start<1||start>7);
	}
	public void SetCalendar()	{
		int row=0;
		int column=start-1;
		for(int i=1;i<=max;i++){
			table[row][column]=i;
			column++;
		if (column%7==0){
			column=0;
			row++;
		}
		}
			
	}
	public void PrintCalendar()	{
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		for(int r=0;r<6;r++){
			for (int c=0;c<7;c++){
				if(table[r][c]>0)
					System.out.print(table[r][c]);
					System.out.print("\t");
				if(c==6)
					System.out.println();
	}}}
}

