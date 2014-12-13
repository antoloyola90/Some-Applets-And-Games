public class BoxDad {
	public char[][] board;
	public int row,col,i,j,num,rnum,cnum;
	
	public BoxDad(){
		
	}

	public static void main(String[] args) {
		BoxDad run=new BoxDad();
		run.Do();
	}
	public void Do(){
		do{	
		GetDoInfo();
		PrintInfo();
		}while(row>30&&row<1||col>30&&col<1);
	}
	public void GetDoInfo(){
		TextReader console=new TextReader();
		
			System.out.print("Enter the number of rows	->");
			row=console.readInt();
			System.out.print("Enter the number of columns	->");
			col=console.readInt();
		
		char[][]board=new char[row][col];
	}
	public void PrintInfo()	{
		//rnum=row;
		//cnum=col;
		row+=2;
		col+=2;
		if((row%2)==1&&(col%2)==1){
			while(row>0&&col>0){
				System.out.print("\n ");
				
				row-=2;
				col-=2;
				for (int i = 1; i <= row; i++) {
					System.out.print("-");
					//row-=2;
				}
				System.out.println();
					for (j = 1; j <= col; j++) {
						System.out.print("|");
						
						for (i = 1; i <= row; i++){
							System.out.print(" ");
							
						}
						
						System.out.println("|");
					}
					
					System.out.print(" ");
					for (int i = 1; i <= row; i++) {
						System.out.print("-");
						
					}
					//row-=2;
				//row-=2;
				//col-=2;
			}
		}
		
		else
			Do();
	}
}
