package work;

public class FactoryA extends Factory{
	
	public Role CreateProduct() {
		return new RoleA();
	}

}
