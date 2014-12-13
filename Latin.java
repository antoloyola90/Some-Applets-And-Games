public class Latin{
	private String phrase, newphrase;
	private char letter, oneletter;
	private TextReader key=new TextReader();
	
	public Latin () {
	}
	
	public static void main (String [] args)	{
		Latin done=new Latin();
		done.Intro();
	}
	
	public void Intro(){
		phrase="";
		while (!phrase.equals("goodbye") && !phrase.equals("Goodbye"))	{
			GetInfo();
			DoInfo();
			PrintInfo();
		}
	}
	
	public void GetInfo()	{
		System.out.print("Enter the word to be translated -> ");
		phrase=key.readLine();
	}
	
	public void DoInfo()	{
		newphrase="";
		for (int i=0; i<phrase.length();i++){
			letter=phrase.charAt(i);
			if(Vowel())	{
				if (i==0){
					newphrase=phrase+"yay";
					break;
				}
				else {
					newphrase=phrase.substring(i)+phrase.substring(0,i)+"ay";
					break;
				}
			}	
		}
		if (!Vowel()){
			newphrase=phrase+"ay";
		}
	}
	
	public boolean Vowel()	{
		switch (letter){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':return true;
			default:return false;
		}
	}
	
	public void PrintInfo()	{
		System.out.println("\nTranslated to                   -> "+newphrase+"\n");
	}
}
