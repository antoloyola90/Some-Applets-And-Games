public class HomeTelephoneBook {
	private int number;
	private TextReader read=new TextReader();
	
	public HomeTelephoneBook()	{
		number=0;
	}
	public static void main(String[] args) {
		HomeTelephoneBook done=new HomeTelephoneBook();
		done.GetInfo();
	}
	
	public void GetInfo()	{
		System.out.print("Enter the # of phone numbers you want to add   ->");
		number=read.readInt();
		String [] name=new String[number];
		String [] cellphone=new String[number];
		String [] officephone=new String[number];
		String [] housephone=new String[number];
		//TextReader key=new TextReader();
		//TextWriter write=new TextWriter("phonebook.txt");
		
		for(int x=0;x<number;x++){
			TextReader key=new TextReader();
			System.out.print("\nEnter the name of the person ->");
			name[x]=key.readLine();
			System.out.print("\nEnter the cellphone # of the person ->");
			cellphone[x]=key.readLine();
			System.out.print("\nEnter the officephone # of the person ->");
			officephone[x]=key.readLine();
			System.out.print("\nEnter the housephone # of the person ->");
			housephone[x]=key.readLine();
			System.out.println("\n"+name[x]);
			System.out.println(cellphone[x]);
			System.out.println(officephone[x]);
			System.out.println(housephone[x]);
		}
	}
}
