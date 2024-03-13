package ecommerce.repository;

import ecommerce.model.Product;

public interface EcommerceRepository {
	
	//CRUD DO ECOMMERCE
	public void listAll();
	public void register(Product product);
	public void update(Product product);
	public void delete(int identifier);
	
}
