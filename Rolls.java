public class Rolls {
	public static void main ( String [] args ) {
		Rolls loop = new Rolls ( );
		loop.GetInfo ( );
		loop.RollTheDice ( );
		loop.ShowResults ( );
	}

		public TextReader keyboard=new TextReader ();
		private int count, target; 				// These values represent how many times the
												//		 dice has been rolled and the target value.
		private int targetcount; 				// How many times the target has been hit.
		private int numsides; 					// The number of sides for the dice.
		private int dicevalue; 					// The number rolled (dice value).
		private int numrolls; 					// Represents the number of times the dice
												//		 will be rolled (where to stop).
		private int max, min; 					// The maximum and minimum value rolled.
		
//		 Sets the values of the above data members.
		
		public Rolls ( ){
			
		}
//		 Prompt the user to enter the desired information.
		
		public void GetInfo ( ){
			System.out.print("Enter the number of sides for your dice (2-100) ->");
			numsides=keyboard.readInt();
			System.out.print("Enter the number of times you would like to roll the dice(1-10000) ->");
			numrolls=keyboard.readInt();
			System.out.print("Enter the target value(1-number of sides) ->");
			target=keyboard.readInt();
			System.out.println();

		}
//		 Roll the dice the desired number of times, looking for the target,
//		 keeping track of how many times the target is hit, and keeping track
//		 of the max and min values rolled.
		
		public void RollTheDice ( ){
			min=numsides;
			max=0;
			count=0;
			targetcount=0;
			
			while (count < numrolls){
				dicevalue=(int)(1 + numsides * Math.random ( ));
				System.out.print(Format.left(dicevalue, 10));
				if (dicevalue==target)
					targetcount+=1;
				if(min>dicevalue)
					min=dicevalue;
				if(max<dicevalue)
					max=dicevalue;
				count++;
				if((count%10)==0)
					System.out.println();
			}
			if((count%10)!=0)
				System.out.println();
		}
			
//		 A table showing the results.
		
		public void ShowResults ( ){
			System.out.println();
			System.out.println("The target of  "+target+"  was rolled  "+targetcount+"  times.");
			System.out.println("Minimum value		-> "+min);
			System.out.println("Maximum value		-> "+max);
			
			
			
		
	}
}
