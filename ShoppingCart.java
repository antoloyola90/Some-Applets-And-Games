public class ShoppingCart {
	private int item, pencilcount, pencount, papercount, erasercount, staplercount;
	
	public ShoppingCart () {
		
	}
	public static void main(String[] args) {
		ShoppingCart buy=new ShoppingCart();
		buy.Get();
		buy.Print();
	}
	
	public void Get() {
		TextReader key=new TextReader();
		System.out.println("  1)  Pencil");
		System.out.println("  2)  Pen");
		System.out.println("  3)  Paper");
		System.out.println("  4)  Eraser");
		System.out.println("  5)  Stapler");
		item=1;
		while (item>0 && item<6){
			System.out.print("\nEnter the item that you want to buy (0 or 6 to quit) ->");
			item=key.readInt();
		
		if (item==1){
			pencilcount=pencilcount+1;
			
		}
		if (item==-1 && pencilcount>0){
			pencilcount=pencilcount-1;
			
		}
		if (item==2){
			pencount=pencount+1;
			
		}
		if (item==-2 && pencount>0){
			pencount=pencount-1;
			
		}
		if (item==3){
			papercount=papercount +1;
			
		}
		if (item==-3 && papercount>0){
			papercount=papercount -1;
			
		}
		if (item==4){
			erasercount=erasercount +1;
			
		}
		if (item==-4 && erasercount>0){
			erasercount=erasercount -1;
			
		}
		if (item==5){
			staplercount=staplercount +1;
			
		}
		if (item==-5 && staplercount>0){
			staplercount=staplercount -1;
			
		}
	
	}
	}

	public void Print ( ) {	
		if (pencilcount!=1)
		System.out.print("\n\nYou have bought "+pencilcount+" pencils!");
		if (pencilcount==1)
			System.out.print("\n\nYou have bought "+pencilcount+" pencil!");
		if (pencount!=1)
			System.out.print("\n\nYou have bought "+pencount+" pens!");
		if (pencount==1)
			System.out.print("\n\nYou have bought "+pencount+" pen!");
		if (papercount!=1)	
			System.out.print("\n\nYou have bought "+papercount+" papers!");
		if (papercount==1)
			System.out.print("\n\nYou have bought "+papercount+" paper!");
		if (erasercount !=1)
			System.out.print("\n\nYou have bought "+erasercount+" erasers!");
		if (erasercount ==1)
			System.out.print("\n\nYou have bought "+erasercount+" eraser!");
		if (staplercount !=1)
			System.out.print("\n\nYou have bought "+staplercount+" staplers!");
		if (staplercount ==1)
			System.out.print("\n\nYou have bought "+staplercount+" stapler!");
	}
	
}
