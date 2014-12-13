public class Rotate {
	
	private String phrase, newphrase;
	private int encription;
	
	public Rotate (){
		encription=0;
	}

	public static void main(String[] args) {
		Rotate done=new Rotate();
		done.Intro();
	}
	
	public void Intro ()	{
		Read();
		for(int i=0; i<13; i++){
			DoPhrase();
			PrintInfo();
			phrase=newphrase;
		}	
	}
	public void Read ()	{
		TextReader key=new TextReader();
		System.out.println("Welcome to Rotate.java. Please enter a word, phrase, or sentence.");
		System.out.print("->     ");
		phrase=key.readLine();
	}
	
	public void DoPhrase ()	{
		int i=0;
		newphrase=""; 
		while (i<phrase.length())	{
			char c=phrase.charAt(i);
			if ((c>='A' && c<='Z') || (c>='a' && c<='z'))	{
				if (c=='y')
					c='a';
				else if (c=='z')
					c='b';
				else if (c=='Y')
					c='A';
				else if (c=='Z')
					c='B';
				else
					c=(char)(c+2);
			}
			newphrase=newphrase+c;
			i++;	
		}
	}
	public void PrintInfo ()	{
		encription++;	
		switch (encription){
				case 1: System.out.println("Encryption 1:");
						System.out.println(newphrase);break;
				case 2: System.out.println("\nEncryption 2:");
						System.out.println(newphrase);break;
				case 3: System.out.println("\nEncryption 3:");
						System.out.println(newphrase);break;
				case 4: System.out.println("\nEncryption 4:");
						System.out.println(newphrase);break;
				case 5: System.out.println("\nEncryption 5:");
						System.out.println(newphrase);break;
				case 6: System.out.println("\nEncryption 6:");
						System.out.println(newphrase);break;
				case 7: System.out.println("\nEncryption 7:");
						System.out.println(newphrase);break;
				case 8: System.out.println("\nEncryption 8:");
						System.out.println(newphrase);break;
				case 9: System.out.println("\nEncryption 9:");
						System.out.println(newphrase);break;
				case 10: System.out.println("\nEncryption 10:");
						System.out.println(newphrase);break;
				case 11: System.out.println("\nEncryption 11:");
						System.out.println(newphrase);break;
				case 12: System.out.println("\nEncryption 12:");
						System.out.println(newphrase);break;
				case 13: System.out.println("\nEncryption 13:");
						System.out.println(newphrase);break;
		}
	}
}
