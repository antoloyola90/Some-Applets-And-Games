public class Plate {
	
	private String peaplate, nopeaplate,plate;
	private TextReader key=new TextReader();

	public static void main(String[] args) {
		Plate done=new Plate();
		done.GetInfo();
	}
	
	public void GetInfo()	{
		System.out.print("Enter the phrase for your plate ->");
		plate=key.readLine();
		DoInfo();
		PrintInfo();
	}
	
	public void DoInfo()	{
		peaplate=plate;
		for (int i=0;i<10;i++)	{
			int x=(int)(Math.random()*peaplate.length());
			peaplate=(peaplate.substring(0,x))+"*"+(peaplate.substring(x));
		}
		
		nopeaplate=peaplate;
		while(true){
			int ix=nopeaplate.indexOf('*');
			
			if (ix<0)	{
				break;
			}
			nopeaplate=(nopeaplate.substring(0,ix)) + (nopeaplate.substring(ix+1));
		}
		
	}
	
	public void PrintInfo()	{
		System.out.println(plate);
		System.out.println(peaplate);
		System.out.println(nopeaplate);
	}
	
}
