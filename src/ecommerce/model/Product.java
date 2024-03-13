package ecommerce.model;

public abstract class Product {
	private int type;
	private String name;
	private String brand;
	private float price;
	private int quantity;
	private int identifier;
	
	public Product(int type, String name, String brand, float price, int quantity, int identifier) {
		this.type = type;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.identifier = identifier;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	
	
	public void view() {
		String type = "";
		
		switch(this.type) {
		case 1:
			type = "Smartphone";
			break;
		
		case 2: 
			type = "Laptop";
			break;
		}
		
		System.out.println("*******************************************");
		System.out.println("Informações do produto");
		System.out.println("*******************************************");
		System.out.println("ID do produto: " + this.identifier);
		System.out.println("Tipo do produto: " + type);
		System.out.println("Nome: " + this.name);
		System.out.println("Marca: " + this.brand);
		System.out.println("Preço (R$): " + this.price);
		System.out.println("Quantidade no estoque: " + this.quantity);
		
	}
}
