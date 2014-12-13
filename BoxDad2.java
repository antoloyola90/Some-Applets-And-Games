public class BoxDad2 {
	public char[][] board;
	public int row,col,i,j,num,rnum,cnum;
	
	public BoxDad2(){
		
	}

	public static void main(String[] args) {
		BoxDad2 run=new BoxDad2();
		run.Do();
	}
	public void Do(){
		GetDoInfo();
		PrintInfo();
	}
	public void GetDoInfo(){
		TextReader console=new TextReader();
		do{
			System.out.print("Enter the number of rows	->");
			row=console.readInt();
		}while(row>30||row<1);
		do{
			System.out.print("Enter the number of columns	->");
			col=console.readInt();
		}while(col>30||col<1);
		char[][]board=new char[row][col];
	}
	public void PrintInfo()	{
		row+=2;
		col+=2;
		if((row%2)==1&&(col%2)==1){
			while(row>0&&col>0){
				System.out.print("\n ");
				row-=2;
				col-=2;
				int r=row%2;
				boolean rheck=true;
				//while (rheck){
					for (int i = 1; i <= row; i++) {
						System.out.print("-");
					//}
					r-=2;
					//if(r%2!=1)
						//rheck=false;
				}
				System.out.println();
					for (j = 1; j <= col; j++) {
						System.out.print("|");
						//int c=col%2;
						//boolean check=true;
						//while (check){
							for (i = 1; i <= row; i++){
							System.out.print(" ");
							}
							System.out.println("|");
							
							//if(c%2!=1)
								//check=false;
							//c-=2;
						}
						//System.out.println("|");
					}
					System.out.print(" ");
					//r=row%2;
					//rheck=true;
					//while (rheck){
						for (int i = 1; i <= row; i++) {
							System.out.print("-");
						}
						
						//if(r%2!=1)
							//rheck=false;
						//r-=2;
					//}
			//}
		}
		
		//else
			Do();
	}
}
