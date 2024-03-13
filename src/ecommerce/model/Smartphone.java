package ecommerce.model;

public class Smartphone extends Product {
	
	private String connectivity;

	public Smartphone(int type, String name, String brand, float price, int quantity, int identifier,String connectivity) {
		super(type, name, brand, price, quantity, identifier);
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.println("Conectividade: " + this.connectivity);
	}
	
}
