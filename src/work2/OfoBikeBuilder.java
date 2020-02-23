package work2;


public class OfoBikeBuilder extends Builder{ 
	 private Bike mBike = new Bike(); 
	 @Override 
	 void buildFrame() { 
	     mBike.setFrame2(new OfoBikeFrame()); 
	 } 
	 @Override 
	 void buildSeat() { 
	     mBike.setSeat2(new OfoBikeSeat()); 
	 } 
	 @Override 
	 void buildTire() { 
	     mBike.setTire2(new OfoBikeTire()); 
	 } 
	 @Override 
	 Bike createBike() { 
	     return mBike; 
	 } 
	} 
