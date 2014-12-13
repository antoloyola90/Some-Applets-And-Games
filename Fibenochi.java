public class Fibenochi {

	public static void main(String[] args) {
		int fibe=1, number, count=0;
		number=fibe;
		while (count>=0 && count<10){
			number=fibe+number;
			number++;
			count++;
		}
		System.out.print(number);
	}
	
}
