//	Anto Loyola		1/7/05
//	Chart.java
//	This program asks for the name of a textfile and it reads from it. It reads how many of each alphabet there is on that
//	textfile. Then it prints out stars with the highest alphabet count being 50. It then divides the other alphabet counts
//	by the higher alphabet count and multipies this by 50 rounding off and then it adds these stars to a graph. 
public class Chart {
	private int [] lowercase=new int[26];
	private TextReader start=new TextReader();

	public Chart()	{
		
	}
	public static void main(String[] args) {
		Chart done=new Chart();
		done.GetInfo();
		
	}
	
	public void GetInfo()	{
		System.out.print("Enter the name of the file you want to read:    ->");
		String input=start.readLine();
		TextReader read=new TextReader(input);
		String file=read.readLine();
		while(file!=null){
			for(int i=0; i<file.length();i++){
				char c=file.charAt(i);
				c=Character.toLowerCase(c);
				if(c>='a'&&c<='z'){
					lowercase[c-'a']++;
				}
			}
			file=read.readLine();
		}
		int lowmax=0;
		for(int i=0;i<26;i++){
			if(lowmax<lowercase[i])
				lowmax=lowercase[i];
		}
		for (int k=50;k>=1;k--) {
			for(int i=0;i<26;i++){
				int stars=(int)(((1.0*lowercase[i])/lowmax)*50.0);
				if (stars>=k)
					System.out.print("*\t");
				else
					System.out.print(" \t");
			}
			System.out.println();
		}
		for(int i=0;i<26;i++)
			System.out.print(lowercase[i]+"\t");
		System.out.println();
		for(int i='a';i<='z';i++)
			System.out.print((char)i+"\t");
		System.out.println();
	}
	
	
}

