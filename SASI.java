//	Anto Loyola		2/18/05
//	SASI.java
//	This program acts as a record of students and reads from a file and arranges it in any choice you give. It will add and
//	delete students also.

public class SASI   {
	private Student[] students;
	private String filename="students.txt";
	private char menu;
	private TextReader key=new TextReader();
	private int number,maxsize;
	public SASI ( )   {
		 //filename= "";
		 number=0;
	}
	
	public static void main ( String[] args )   {
		SASI mylist = new SASI();
		mylist.DoMain();
	}
	public void DoMain()	{
		Read();
		ReadList();
		while(menu!='q'&&menu!='Q'){
			ReadMenu();
			DoCommand();
		}
	}
	public void Read(){
		System.out.print("Enter the textfile thay you wish to read from\t->");
		filename=key.readLine();
		//System.out.println(new java.io.File(".").getAbsolutePath());
	}
	
	public void ReadList(){
		TextReader console=new TextReader(filename);
		TextReader console1=new TextReader(filename);
		String count=console1.readLine();
		while(count!=null){
			number++;
			count=console1.readLine();
		}
		maxsize=number+250;
		students=new Student[maxsize];
		for (int i=0; i<number;i++){
			students[i]=new Student();
			students[i].lastname=console.readWord();
			students[i].firstname=console.readWord();
			students[i].studentId=console.readLong();
			students[i].month=console.readInt();
			students[i].day=console.readInt();
			students[i].year=console.readlnInt();
			
		}
		console.close();
		console1.close();
	}
	
	public void ReadMenu(){
		while (true) {
			System.out.print("---------------\n(1) Add student(s)\n(2) Delete student(s)\n(3) Sort by last name\n(4) Sort by student id"+
			"\n(5) Sort by birth date\n(6) Print student list\n(Q) Quit\n---------------\n\nEnter Command\t->");
			String c = key.readLine();
			if (c != null && c.length() == 1) {
				menu = c.charAt(0);
				if (menu >= '1' && menu <= '6'||menu=='q'||menu=='Q')
					break;
			}
			
		}
		
	}
	public void DoCommand(){
		switch(menu){
			case '1':AddStudent();break;
			case '2':DelStudent();break;
			case '3':LastSort();break;
			case '4':IdSort();break;
			case '5':BirthDaySort();break;
			case '6':PrintList();break;
			case 'q':
			case 'Q':Quit();break;
			
		}
	}
	public void DelStudent(){
		System.out.print("Enter last name of the student you want to delete ->");
		String last=key.readLine();
		System.out.print("Enter first name of the student you want to delete ->");
		String first=key.readLine();
		int i=0;
		boolean check=false;
		for (i=0;i<number;i++){
			if (students[i].lastname.equals(last)&&students[i].firstname.equals(first)){
				break;
			}
		}
		if(i>=number){
			System.out.println(last+" "+first+" not found");
			return;
		}
		number-=1;
		for(int j=i;j<number;j++){
			students[j]=students[j+1];
		}
		System.out.println(last+" "+first+" deleted");
		
	}
	public void LastSort(){
		for (int outer = 1; outer < number; outer++){
			
		    int position = outer;
		    Student tmp=students[position];
		    String key = students[position].lastname;
			
		    while (position > 0 && students[position-1].lastname.compareTo(key)>0){
		    	swap(position, position-1);
		    	position--;
		    }
		    students[position] = tmp;
		 }
		System.out.println("\nStudents are now sorted by last name.");
				
	}
	public void IdSort(){
		for (int outer = 1; outer < number; outer++){
			
		    int position = outer;
		    Student tmp=students[position];
		    long key = students[position].studentId;
			
		    while (position > 0 && students[position-1].studentId > key){
		    	swap(position, position-1);
		    	position--;
		    }
		    students[position] = tmp;
		 }
		System.out.println("\nStudents are now sorted by id number.");
		
	}
	
	private void swap(int i, int j) {
		Student tmp=students[i];
		students[i]=students[j];
		students[j]=tmp;
	}
	public void BirthDaySort(){
		for (int outer = 1; outer < number; outer++){
			
		    int position = outer;
		    Student tmp=students[position];

			
		    while (position > 0 && (students[position-1].year > tmp.year || 
		    		(students[position-1].year == tmp.year && students[position-1].month > tmp.month) ||
		    		(students[position-1].year == tmp.year && students[position-1].month == tmp.month && 
		    				students[position-1].day > tmp.day))) {
		    	swap(position, position-1);
		    	position--;
		    }
		    students[position] = tmp;
		 }
	}
	public void PrintList(){
		for (int i=0; i<number;i++){ 
			students[i].Print();
		}
	}
	public void Quit(){
		System.out.print("Do you want to save changes (Y or N) ?");
		char let=key.readAnyChar();
		TextWriter write=new TextWriter(filename);
		if(let=='y'||let=='Y'){
			for(int i=0;i<number;i++){
				write.println(students[i].toString());
			}
			System.out.println("File has been saved.\n\n Have a nice day!!");
		}
		write.close();
	}
	public void AddStudent()	{
		while(number<maxsize){			
			int i=number;
			number++;
			students[i]=new Student();
			System.out.print("Enter last name of the student ->");
			students[i].lastname=key.readLine();
			System.out.print("Enter first name of the student ->");
			students[i].firstname=key.readLine();
			System.out.print("Enter the student id ->");
			students[i].studentId=key.readInt();
			do{
			System.out.print("Enter the month of birth ->");
			students[i].month=key.readInt();
			}while(students[i].month>12||students[i].month<1);
			do{
			System.out.print("Enter the day of birth ->");
			students[i].day=key.readInt();
			}while(students[i].day>31||students[i].day<1);
			System.out.print("Enter the year of birth ->"); 
			students[i].year=key.readInt();
			System.out.print("Do you want to add another student (Yes or No) ?");
			String c=key.readLine();
			while (true) {
				if(c!=null){
				char tmp = c.charAt(0);
				if (tmp == 'n'||tmp=='N')
					return;
				if (tmp == 'y'||tmp=='Y')
					break;
				}
				c=key.readLine();
			}
			
		}
		
	}
	
}	

class Student {
	String lastname;
	String firstname;
	long studentId;
	int month;
	int day;
	int year;
	
	public void Print(){
		System.out.println(toString());
	}
	
	public String toString(){
		return lastname+"\t"+firstname+"\t"+studentId+
				"\t"+month+"\t"+day+"\t"+year+"\t";
	}
}