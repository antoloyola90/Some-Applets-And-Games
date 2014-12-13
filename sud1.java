public class sud1 {
	public static void main(String[] args) {
		int count = 0, b = 0, l = 4, q = l - 1, e = l + 2, r = l + 3, t = l + 5;
		//TextReader keyboard = new TextReader();
		for (int x = 1; x < l; x++) {
			for (int j = 1; j < l; j++) {
				for (int i = 1; i < l * 3 + 1; i++) {
					if (i <= q) {
						if (i == 1)
							System.out.print("        ");
						System.out.print("  " + i);

					}
				}
			}
			for (int j = 1; j < l; j++) {
				for (int i = 1; i < l * 3 + 1; i++) {
					if (i <= e && i >= l) {
						if (i == l && count == 0) {
							System.out.print("\n");
							count++;
						}
						if (i == l)
							System.out.print("        ");
						System.out.print("  " + i);
					}
				}
			}
			for (int j = 1; j < l; j++) {
				for (int i = 1; i < l * 3 + 1; i++) {
					if (i <= t && i >= r) {
						if (i == r && b == 0) {
							System.out.print("\n");
							b++;
						}
						if (i == r)
							System.out.print("        ");
						System.out.print("  " + i);
					}
				}
			}
			System.out.println("\n");
			count = b = 0;
		}

		
		/*for (int x = 1; x < l; x++) {
			for (int j = 1; j < l; j++) {
				for (int i = 1; i < l * 3 + 1; i++) {
					if (i <= q) {
						if (i%3==1||i%3==2){
							System.out.print("        ");
							System.out.print(" " + i);
						}
						else if (i%4==2||i%4==2||i%4==0){
							System.out.print("        ");
							System.out.print(" " + i);
						}
						else if (i%3==0){
							System.out.print("        ");
							System.out.print(" " + i);
						}

					}
				}
			}
		}*/
	}
}
