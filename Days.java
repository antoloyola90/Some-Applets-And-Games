public class Days {
	private TextReader key=new TextReader();
	private int month, year, day, jan, feb, mar, apr, may, jun, july, aug, sept, oct, nov, dec;;
	public Days (){
	}
	
	public static void main (String [] args){
		Days done=new Days();
		done.GetInfo();
	}
	
	public void GetInfo()	{
		System.out.print("Enter the month ->");
		month=key.readInt();
		System.out.print("Enter the year  ->");
		year=key.readInt();
		DoInfo();
	}
	public void DoInfo()	{
		if (year<0 || month>12 && month<1)
			GetInfo();
		if (year>0 && month<=12 && month>=1){
			day=01/01/01;
			jan =31;
			if ((year%4)==0)
				feb=29;
			else 
				feb=28;
			mar=31;
			apr=30;
			may=31;
			jun=30;
			july=31;
			aug=31;
			sept=30;
			oct=31;
			nov=30;
			dec=31;
			
		}
			
	}
	
}