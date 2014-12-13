public class PolygonTest  {
	public static void main(String[] args) {
	RegularPolygon poly1 = new RegularPolygon();
	System.out.println( "\n\nnumber of sides                = " + Format.right(poly1.getNumside(),11) );
	System.out.println( "length of side                 = " + Format.right(poly1.getSideLength(), 14, 2) );
	System.out.println( "radius of circumscribed circle = " + Format.right(poly1.getR(), 14, 2) );
	System.out.println( "radius of inscribed circle     = " + Format.right(poly1.getr(), 14, 2) );
	System.out.println( "angle of vertex                = " + Format.right(poly1.vertexAngle(),14,2) );
	System.out.println( "number of diagonals            = " + Format.right(poly1.numDiagonals(),14,2) );
	System.out.println( "perimeter                      = " + Format.right(poly1.Perimeter(), 14, 2) );
	System.out.println( "area                           = " + Format.right(poly1.Area(), 14, 2) );
	System.out.println();
	RegularPolygon poly2 = new RegularPolygon(100000000, .0001);
	System.out.println( "\n\nnumber of sides                = " + Format.right(poly2.getNumside(),11) );
	System.out.println( "length of side                 = " + Format.right(poly2.getSideLength(), 14, 2) );
	System.out.println( "radius of circumscribed circle = " + Format.right(poly2.getR(), 14, 2) );
	System.out.println( "radius of inscribed circle     = " + Format.right(poly2.getr(), 14, 2) );
	System.out.println( "angle of vertex                = " + Format.right(poly2.vertexAngle(),14,2) );
	System.out.println( "number of diagonals            = " + Format.right(poly2.numDiagonals(),14,2) );
	System.out.println( "perimeter                      = " + Format.right(poly2.Perimeter(), 14, 2) );
	System.out.println( "area                           = " + Format.right(poly2.Area(), 14, 2) );
	System.out.println( "Math.PI = " + Math.PI );
	System.out.println( "PI?     = " + poly2.Area()/(poly2.getr()*poly2.getR()) + "\n\n\n" );
	}
}