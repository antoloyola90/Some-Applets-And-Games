public class Cylinder extends Circle {
	protected double height;
	
	public static void main ( String [] args ) {
		Circle circ = new Circle ( 2.1 );
		circ.PrintArea ( );
		Cylinder can = new Cylinder ( 3.2, 2.7 );
		can.PrintVolume ( );
		System.out.println ( "\nThe volume of the cylinder is: " +
		Format.right ( can.Volume ( ),8,3 ) + "\n\n" );
	}
	
	public Cylinder (double cradius, double cheight)	{
		super(cradius);
		height=cheight;
	}
	public void PrintVolume()	{
		PrintArea();
		System.out.println ( "\nHeight = " + Format.right ( height, 8, 3 ) );
		System.out.println ( "\nVolume = " + Format.right ( Volume ( ), 8, 3 ) );
	}
	
	public double Volume()	{
		return(Area()*height); 
	}
}