public class Madlib 	{
	
	private String verb, noun, adjective, place;
	private char phrasechoice;
	private TextReader key=new TextReader();
	
	public Madlib ()	{
	
	}

	
	public static void main (String [] args)	{
		Madlib fillin = new Madlib ();
		fillin.GetInfo();
		fillin.ChoosePhrase();
		fillin.PrintPhrase ();
	}
	
	public void GetInfo ()	{
		System.out.print("Enter a adjective          ->");
		adjective=key.readLine();
		System.out.print("Enter a verb (past tense)  ->");
		verb=key.readLine();
		System.out.print("Enter a noun               ->");
		noun=key.readLine();
		System.out.print("Enter a place              ->");
		place=key.readLine();
	}
	
	public void ChoosePhrase ()	{
		do {	
			System.out.println("1) Mockingbird");
			System.out.println("2) Garbage Dumps");
			System.out.print("3) The Hamster       -------->");
			phrasechoice= key.readChar();
		} while(phrasechoice<'1' || phrasechoice>'3' );//&& phrasechoice!='3');
	}
	
	public void PrintPhrase ()	{
		switch (phrasechoice){
			case '1':System.out.print("My mockingbird " +verb+" the "+
				noun+" and he lived "+adjective+" ever after in "+place+"."); break;
			case '2':System.out.print("The garbage dump " +verb+" the "+
				noun+" and it lived "+adjective+" ever after in "+place+"."); break;
			case '3':System.out.print("Our "+adjective+" hamster " +verb+" the "+
				noun+" and she lived happily ever after in "+place+"."); break;
		}
	}
}
