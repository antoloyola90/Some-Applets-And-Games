

public class Distance {
	
	private double x1, y1, x2, y2;
	
	public Distance(double ix1, double iy1, double ix2, double iy2) {
	
		x1=ix1;
		y1=iy1;
		x2=ix2;
		y2=iy2;
		
	}	
	
	public void DisplayPoints() {
		System.out.println("( "+Format.decimalPlaces(x1,2)+", "+
				Format.decimalPlaces(y1,2)+" ), ( "+
				Format.decimalPlaces(x2,2)+", "+Format.decimalPlaces(y2,2)+
				" )" );
	}
	
	public double Vertical() {
		return Math.abs(y2-y1);
	}
	
	public double Horizontal() {
		return Math.abs(x2-x1);
	}
	
	public void ShowDistance() {
		System.out.println("Total distance = "+
				Format.decimalPlaces(Math.sqrt(Math.pow(y1-y2,2)+Math.pow(x1-x2,2)),2)+"\n\n");
	}
	
}

