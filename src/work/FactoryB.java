package work;

public class FactoryB extends Factory{
	
	public Role CreateProduct() {
	return new RoleB();
}

}
