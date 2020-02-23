package work2;

public class Leader {
	    private Builder mBuilder = null; 
	    
	    public Leader(Builder builder) { 
	        mBuilder = builder; 
	    }
	    public void setBuilder(Builder builder) {
	    	 mBuilder = builder; 
	    }
	    public Bike construct() { 
	        mBuilder.buildFrame(); 
	        mBuilder.buildSeat(); 
	        mBuilder.buildTire(); 
	        return mBuilder.createBike(); 
	    } 

}
