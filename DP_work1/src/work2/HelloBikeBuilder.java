package work2;

//æﬂÃÂ builder ¿‡ 
public class HelloBikeBuilder extends Builder{ 
 private Bike mBike = new Bike(); 
 @Override 
 void buildFrame() { 
     mBike.setFrame1(new HelloBikeFrame());
 } 
 @Override 
 void buildSeat() { 
     mBike.setSeat1(new HelloBikeSeat()); 
 } 
 @Override 
 void buildTire() { 
     mBike.setTire1(new HelloBikeTire()); 
 } 
 @Override 
 Bike createBike() { 
     return mBike; 
 } 
} 


