public class JavaExam1 {

	public static void main(String[] args) {
		TextReader reader=new TextReader();
		
		int number1 = (int)(76+67.2/14.4)%14;
		double number2 = (double)55/4-(int)5.6*3.3333;
		char number3 = (char)(85 + 3%14 - 92/7%11);
		
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(number3);
		System.out.print("type a char ");
		/*number1=reader.readlnChar();
		System.out.println(number1);
		*/
		System.out.println(Format.decimalPlaces(number2, 3));
	}
}
