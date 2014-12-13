
public class Janet {
/*	
	public static int Factorial (int x){
		int f=0;
		for (int i=1; i<=x; i++){
			f=f+i;
		}
		return f;
		
	}
*/	
	public static int Exponents (int number, int power){
		int result=1,numbercount=1;
		while (numbercount<=power){
			result=result*number;
			numbercount++;
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		int year=18,p=1;
		int a=year%19;
		int b=year/100;
		System.out.print(p=p++);
	

			
	}
}