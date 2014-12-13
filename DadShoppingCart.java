public class DadShoppingCart {
	private String[] itemNames={"Pencil","Pen","Paper","Eraser","Stapler","mouse","anto_paper"};
	private int[] items=new int[itemNames.length];
	
	public DadShoppingCart () {
	}
	
	public static void main(String[] args) {
		DadShoppingCart buy=new DadShoppingCart();
		buy.Get();
		buy.Print();
	}
	
	public void Get() {
		TextReader key=new TextReader();
		for (int i=0;i<itemNames.length;i++)
			System.out.println((i+1)+") "+itemNames[i]);
		int item=1;
		boolean neg=false;
		while (item<itemNames.length){
			System.out.print("\nEnter the item that you want to buy (0 or 6 to quit) ->");
			item=key.readInt();
			neg=item<0;
			if (neg)
				item=-item;
			item=item-1;
			if (item>=0&&item<itemNames.length)
			if (neg) {
				if (items[item]>0)
					items[item]--;
			}
			else
				items[item]++;
		}
	}

	public void Print ( ) {	
		for (int i=0;i<itemNames.length;i++)
			System.out.print("\n\nYou have bought "+items[i]+" "+itemNames[i]+"!");
	}
	
}
