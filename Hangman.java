public class Hangman {
	private String original, stars, guessed;
	private int totalwrong;
	private char letter;
	
	public Hangman ()	{
		original=stars=guessed="";
		totalwrong=0;
		letter=' ';
	}
	
	public static void main (String [] args)	{
		Hangman game=new Hangman();
		game.Playgame ();
	}
	
	public void Playgame ()	{
		Intro ();
		AskForPhrase();
		do {
			PrintStatus();
			AskAndGetGuess ();
			CheckGuess();
		} while (totalwrong<6 && !original.equals(stars));
		EndMessage();
		
	}
	
	public void Intro ()	{
		System.out.println("\n\nWelcome to the game of Hangman!\n");
		System.out.println("Player 1 will enter a word or phrase, then player 2 will");
		System.out.println("\tattempt to guess the phrase or until they run out of guesses");
	}
	
	public void AskForPhrase ()	{
		TextReader console = new TextReader();
		System.out.print("Enter a word or phrase for the other player to guess	------>");
		original=console.readLine ();
		for (int i=0; i<original.length(); i++)	{
			if (original.charAt(i)==' ')
				stars += " ";
			else
				stars+="*";
		}
	}
	
	
	
	public void PrintStatus ()	{
		
System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(stars);
		System.out.println("\nthe Letters you have guessed are: "+ guessed);
		System.out.println("\nThe number of wrong guessses (6 and you lose) : "+ totalwrong);
	}
	
	public void AskAndGetGuess ()	{
		TextReader keyboard = new TextReader ();
		do {
			System.out.print ("\nEnter a leter guess: ");
			letter = keyboard.readlnChar ();
		} while(guessed.indexOf (letter) != -1);
		guessed+= (" "+letter);
	}
	
	public void CheckGuess ()	{
		if (original.indexOf (letter) == -1)
			totalwrong ++;
		else {
			
			for(int i=0; i< original.length (); i++)
				if (original.charAt (i) == letter)
			 		stars= stars.substring ( 0, i) +letter + stars.substring ( i + 1);
			
		}
	}
	
	public void EndMessage ()	{
	}
}
