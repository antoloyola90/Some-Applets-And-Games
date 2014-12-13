public class MaxMin	{
	public int max=0, min=10000;
	
	public MaxMin()	{
	
	}
	
	public static void main(String[]args)	{
		MaxMin done=new MaxMin();;
		done.doInfo();
	}
	
	public void doInfo()	{
		TextReader key=new TextReader("numbers.txt");
		TextWriter wey=new TextWriter("out.txt");
		
		int number=key.readInt();
		while (number>0){
			if (max<number)
				max=number;
			if (min>number)
				min=number;
			number=key.readInt();
		}
		System.out.println("Your program should print out (both to the screen and to "+"out.txt"+"):");
		System.out.println("\nMaximum:	"+max);
		System.out.println("Minimum:	"+min);
		wey.println("Maximum:	"+max);
		wey.println("Minimum:	"+min);
		key.close();
		wey.close();
	}

}