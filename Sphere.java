public class Sphere {
	private TextReader keyboard=new TextReader(); 
private double radius; // The radius of the sphere
// Initialize value for radius to 5.0

public Sphere ( ){
	radius=5;
}
// Initialize value for radius to r
public Sphere ( double r ){
	radius=r;
}
//Methods:
// Prompt the user to enter the radius
public void GetRadius ( )	{
	System.out.print("Enter a double for the radius -> ");
	radius=keyboard.readDouble();	
}
// Calculate the volume of the sphere using the formula v = (4/3)(pi)r^3
// and return it
public double FindVolume ( ){
	double volume=(4.0/3)*(Math.PI)*Math.pow(radius,3);
	return volume;
}
// Calculate the surface area of the sphere using the formula
// s = 4(pi)r^2 and return it

public double FindSurface ( ){
	double surfaceArea=4*(Math.PI)*Math.pow(radius,2);
	return surfaceArea;
}
// Display the radius, volume and surface area of the sphere. Format the
// doubles to 3 decimal places. Call the methods FindVolume and FindSurface
// when appropriate.

public void DisplayInfo ( ){
	System.out.println("\n");
	System.out.println("Radius:		"+Format.right(radius, 11, 3));
	System.out.println("Volume:		"+Format.right(FindVolume(), 11, 3));
	System.out.println("Surface Area:	"+Format.right(FindSurface(), 11, 3));
}

}