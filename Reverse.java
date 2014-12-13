public class Reverse {
	private String phrase;
	TextReader key=new TextReader();
	

	
	public static void main(String[] args) {
		Reverse done=new Reverse();
		done.DoWork();
	}
	public void DoWork() {
		do {
		GetInfo();
		System.out.println(reverse(phrase));
		}while(false==phrase.equalsIgnoreCase("q"));
		
	}
	public String reverse(String s) {
		if (s.length()==1)
			return s;
		return reverse(s.substring(1))+s.substring(0,1);
	}
	public void GetInfo()	{
		do {
			System.out.print("Enter a phrase ('q' or 'Q' to quit): ");
			phrase=key.readLine();
		} while (phrase==null);
		phrase=phrase.trim();
	}

}
