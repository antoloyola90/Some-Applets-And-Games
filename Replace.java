//	Anto Loyola			1/7/05
//	Replace.java
//  This program asks you to enter the name of a textfile and it opens it reads everything in that file. It then asks
//	you to enter a letter to replace and a letter to replace with. It replaces the first letter with the second all through
//	file until the end. It then prints this new line out. It also prints it to a textfile that you specify.
public class Replace {
 	
 	private String input, input1;
 	private char letter, letter1;
 	private TextReader cone=new TextReader();
 	
 
 	public Replace(){
 	 

 	}
 	public static void main(String[] args) {
  		Replace done=new Replace();
  		done.DoInfo();
 	}
 	int max (int a, int b) // returns the larger of two integers
 	{
 	   return (a > b) ?a : b;
 	}


 
 	public void DoInfo(){
  		System.out.print("Enter the name of the text file to read from:  ");
  		input=cone.readLine();
  		System.out.print("Enter the name of the text file to write to:   ");
  		input1=cone.readLine();
  		System.out.print("Enter the character to replace:                ");
  		letter=cone.readChar();
  		System.out.print("Enter the character to replace with:           ");
  		letter1=cone.readChar();
  		TextReader read=new TextReader(input);
  		TextWriter write=new TextWriter(input1); 
		String line=read.readLine();
		while (line!=null){
			/*for(int i=0;i<line.length();i++){
				if (line.charAt(i)==letter){
					System.out.print(letter1);
					write.print(letter1);
				}
				else {
					System.out.print(line.charAt(i));
					write.print(line.charAt(i));
				}
				
			}*/
			System.out.println(line.replace(letter,letter1));
			write.println(line.replace(letter,letter1));
			line=read.readLine();
		}
		read.close();
		write.close();
 	}
 	
}

