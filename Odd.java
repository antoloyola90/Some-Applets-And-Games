public class Odd {
	public int number;
	
	public Odd()	{
	}

	public static void main(String[] args) {
		//System.out.println(new java.io.File("out.txt").exists());
		Odd done=new Odd();
		done.DoInfo();
		//done.PrintInfo("ints.txt");
		done.PrintInfo("oddints.txt");
		
	}
	
	public void DoInfo(){
		TextReader r=new TextReader("ints.txt");
		TextWriter w=new TextWriter("oddints.txt");
		int count=1;
		number=r.readInt();

		while (number>0) {
			while (number%2==0)
				number=number/2;
			if (count%10==0)
				w.println(number);
			else {
				w.print(number);
				w.print(" ");
			}
			number=r.readInt();
			count++;
		}
		r.close();
		w.close();
	}
	
	public void PrintInfo(String filename){
		TextReader r=new TextReader(filename);
		int count=1;
		int number=r.readInt();
		System.out.println("Your program should print to "+"oddints.txt"+" (also printed to screen):");
		while (number>0) {
			if (count%10==0)
				System.out.println(number);
			else
				System.out.print(number+"  ");
			number=r.readInt();
			count++;
		}
		r.close();
	}	
	
	
}
