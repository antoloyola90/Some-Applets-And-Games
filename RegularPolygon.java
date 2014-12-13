public class RegularPolygon	{
		private int myNumSides=3; // # of sides
		private double mySideLength=1.0; // length of side
		private double myR; // radius of circumscribed circle
		private double myr; // radius of inscribed circle
		// constructors
		public RegularPolygon() {	
			calcr();
			calcR();
		}
		public RegularPolygon(int numSides, double sideLength) {
			myNumSides=numSides;
			mySideLength=sideLength;
			calcr();
			calcR();
		}
		// methods
		public void calcr() {
			myr=0.5*mySideLength*(1/Math.tan(Math.toRadians(180)/myNumSides));
		}
		public void calcR() {
			myR=0.5*mySideLength*(1/Math.sin(Math.toRadians(180)/myNumSides));
		}
		public double vertexAngle() {
			return  ((myNumSides-2.0)/myNumSides)*180;
		}
		
		public double Perimeter() {
			return myNumSides*mySideLength;
		}
		public double Area() {
			return 0.5*myNumSides*Math.pow (myR,2)*Math.sin(Math.toRadians(360)/myNumSides);
		}
		public double numDiagonals() {
			return (1.0*myNumSides*(myNumSides-3))/2;
		}
		public int getNumside() {
			return myNumSides;
		}
		public double getSideLength() {
			return mySideLength;
		}
		public double getR() {
			return myR;
		}
		public double getr() {
			return myr;
	}
}