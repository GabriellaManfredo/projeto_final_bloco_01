package ecommerce.model;

public class Laptop extends Product{

	private String ramMemory;
	
	public Laptop(int type, String name, String brand, float price, int quantity, int identifier, String ramMemory) {
		super(type, name, brand, price, quantity, identifier);
		this.ramMemory = ramMemory;
	}

	@Override
	public void view() {
		super.view();
		System.out.println("Memória RAM: " + this.ramMemory);
	}
}
