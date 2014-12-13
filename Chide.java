public class Chide {
	private TextReader reader=new TextReader();
 	private int Atotal=1, Btotal=1, anumber, bnumber;
	private boolean Aturn=true, done;

	 public Chide () {
 	}
	
	public static void main(String[] args) {
		Chide done=new Chide ();
		done.PlayGame();
	} 
	
	public void PlayGame () {
		do {
			ShowStatus();
			MoveIt();
		} while (Atotal<41 && Btotal<41);
		ShowStatus();
		PrintWinner();
	}
	
	public void ShowStatus () {
		System.out.println("A TOTAL IS: "+Atotal);
		System.out.println("B TOTAL IS: "+Btotal);
	}
	
	public void MoveIt () {
		if (Aturn) {
			System.out.println("Player A, hit Enter to continue: ");
			reader.readLine();
			anumber=(int)(Math.random()*8+1);
			System.out.println("\n"+anumber+"\n");
			if (anumber==3 || anumber==7)
				System.out.println("Sorry, you rolled a "+anumber);
			else {
				Atotal=anumber+Atotal;
				if (Atotal%6==0){
					System.out.println("Whoops, you landed on a multiple of 6, "+Atotal);
					if ((Atotal-(2*anumber))>=1) 
						Atotal=Atotal-(2*anumber);
				}
			}
			if ((int)Math.pow((int)Math.sqrt(Atotal), 2.0)==Atotal)
				System.out.println("Hey, you landed on a perfect square!");
			else
				Aturn=false;
		}
		else {
			System.out.println("Player B, hit Enter to continue: ");
			reader.readLine();
			bnumber=(int)(Math.random()*8+1);
			System.out.println("\n"+bnumber+"\n");
			if (bnumber==3 || bnumber==7)
				System.out.println("Sorry, you rolled a "+bnumber);
			else {
				Btotal=bnumber+Btotal;
				if (Btotal%6==0) {
					System.out.println("Whoops, you landed on a multiple of 6, "+Btotal);
					if ((Btotal-(2*bnumber))>=1)
						Btotal=Btotal-(2*bnumber);
				}
			}
			if ((int)Math.pow((int)Math.sqrt(Btotal), 2.0)==Btotal)
				System.out.println("Hey, you landed on a perfect square!");
			else
				Aturn=true;
		}
	}
	
	public void PrintWinner () {
		if (Atotal>40)
			System.out.println("\nA, you are the VICTOR!!!");
		else 
			System.out.println("\nB, you are the VICTOR!!!");
	}
			
}
