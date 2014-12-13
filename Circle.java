public class Circle {
	protected double radius;
	
	public Circle ( ) {
		radius = 1.0;
	}
	public Circle (double r) {
		radius = r;
	}
	public double Area ( ) {
		return ( Math.PI * radius * radius );
	}
	public void PrintArea ( ) {
		System.out.print ( "\nradius = " + Format.right ( radius, 8, 3 ) );
		System.out.print ( "\nArea = " + Format.right ( Area ( ), 8, 3 ) );
	}
}