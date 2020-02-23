package work;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factory factory=new FactoryA();
		Role role=factory.CreateProduct();
		role.fight();
		
		factory=new FactoryB();
		role=factory.CreateProduct();
		role.fight();

	}

}
