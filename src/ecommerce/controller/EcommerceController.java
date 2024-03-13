package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Product;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository{

	private ArrayList<Product> productsList = new ArrayList<Product>();
	int identifier = 0;
	
	@Override
	public void listAll() {
		for (var product : productsList) {
			product.view();
		}
		
	}

	@Override
	public void register(Product product) {
		productsList.add(product);
		System.out.println("\nO produto de ID: " + product.getIdentifier() + " foi cadastrado com sucesso!");
		
	}

	@Override
	public void update(Product product) {
		var searchProduct = searchInTheCollection (product.getIdentifier());
		
		if(searchProduct != null) {
			productsList.set(productsList.indexOf(searchProduct), product);
			System.out.println("\nO produto foi atualizado com sucesso!" );	
		} else {
			System.out.println("\nO produto não foi encontrado!");
		}
		
	}

	@Override
	public void delete(int identifier) {
		var product = searchInTheCollection (identifier);
		
		if(product != null) {
			if(productsList.remove(product) == true) {
				System.out.println("\nO produto de ID: " + identifier + " foi deletado!");
			}
		} else {
			System.out.println("\nO produto de ID: " + identifier + " não foi encontrado!");
		}
	}
	
	public int generateIdentifier() {
		return ++ identifier;
	}
	
	
	public Product searchInTheCollection (int identifier) {
		for (var product : productsList) {
			if(product.getIdentifier() == identifier) {
				return product;
			}
		}
		return null;
	}

}
