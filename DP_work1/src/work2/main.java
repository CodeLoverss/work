package work2;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����hellobike
		Leader leader = new Leader(new HelloBikeBuilder()); 
        Bike bike = leader.construct(); 
        
        //����ofo
        leader.setBuilder(new OfoBikeBuilder());
        bike = leader.construct(); 
		

	}

}
