package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.Laptop;

import ecommerce.model.Smartphone;
import ecommerce.util.colors;

public class menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EcommerceController products = new EcommerceController();
		
		int option, type, quantity, identifier;
		String name, brand, connectivity, ramMemory;
		float price;
		
		System.out.println("\nCadastrar produtos\n");
		Smartphone sp1 = new Smartphone(1, "Iphone 15", "Apple", 4200.0f, 3, products.generateIdentifier(), "5G");
		products.register(sp1);
		
		Smartphone sp2 = new Smartphone(1, "Galaxy A20", "Samsung", 1700.0f, 6, products.generateIdentifier(), "4G");
		products.register(sp2);
		
		Laptop lt1 = new Laptop(2, "MacBook", "Apple", 6000.0f, 5, products.generateIdentifier(), "8GB");
		products.register(lt1);
		
		Laptop lt2 = new Laptop(2, "Galaxy Book", "Samsung", 4900.0f, 10, products.generateIdentifier(), "16GB");
		products.register(lt2);
		
		while (true) {
			
			System.out.println(colors.TEXT_PURPLE_BRIGHT + colors.ANSI_BLACK_BACKGROUND);
			
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("                   GabsTechStore                      ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("             1 - Cadastrar produto                        ");
			System.out.println("             2 - Listar produto                       ");              
			System.out.println("             3 - Atualizar produto                    ");
			System.out.println("             4 - Apagar produto                       ");                                 
			System.out.println("             5 - Sair                                 ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("Entre com a opção desejada:                           ");
			System.out.println("                                                      ");
			
			try {
				option = scanner.nextInt();
			} catch (InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				option = 0;
			}
			
			
			if (option == 5) {
				System.out.println(colors.TEXT_WHITE_BOLD + "\nGabsTechStore: Inovação ao seu alcance!");
				about();
				scanner.close();
				System.exit(0);
			}
			
			switch (option) {
			case 1:
				System.out.println(colors.TEXT_WHITE + "Cadastrar produto");
				
				System.out.println("Digite a marca do produto");
				brand = scanner.nextLine();
				scanner.next();
				System.out.println("Digite o nome do produto");
				name = scanner.nextLine();
				scanner.next();
				
				do {
					System.out.println("Digite a categoria do produto (1 - Smartphone ou 2 - Laptop)");
					type = scanner.nextInt();
				} while(type < 1 && type > 2);
				
				System.out.println("Digite o preço do produto (R$)");
				price = scanner.nextFloat();
				System.out.println("Digite a quantidade no estoque do produto:");
				quantity = scanner.nextInt();
				
				switch(type) {
				case 1 ->{
					System.out.println("Digite a conectividade do smartphone: ");
					connectivity = scanner.nextLine();
					scanner.next();
					products.register(new Smartphone(type, name, brand, price, quantity, products.generateIdentifier(), connectivity));
				}
				
				case 2 -> {
					System.out.println("Digite a quantidade de memória RAM: ");
					ramMemory = scanner.nextLine();
					scanner.next();
					products.register(new Laptop(type, name, brand, price, quantity, products.generateIdentifier(), ramMemory));
				}
				}
				
				keyPress();
				break;
					
			case 2:
				System.out.println(colors.TEXT_WHITE + "Listar produto");
				products.listAll();
				keyPress();
				break;
					
			case 3:
				System.out.println(colors.TEXT_WHITE + "Atualizar produto");
				
				System.out.println("Digite o ID do produto");
				identifier = scanner.nextInt();
				scanner.nextLine();
				
				var searchProduct = products.searchInTheCollection(identifier);
				
				if(searchProduct != null) {
					type = searchProduct.getType();
					
					System.out.println("Digite a marca do produto");;
					brand = scanner.nextLine();
					
					
					System.out.println("Digite o nome do produto: ");
					name = scanner.nextLine();
					
					
					System.out.println("Digite o preço do produto (R$)");
					price = scanner.nextFloat();

					System.out.println("Digite a quantidade no estoque do produto:");
					quantity = scanner.nextInt();
					
					scanner.nextLine();
					
					switch(type) {
					case 1 ->{
						System.out.println("Digite a conectividade do smartphone: ");
						connectivity = scanner.nextLine();
						
						products.update(new Smartphone(type, name, brand, price, quantity, identifier, connectivity));
					}
					
					case 2 -> {
						System.out.println("Digite a quantidade de memória RAM: ");
						ramMemory = scanner.nextLine();
						
						products.update(new Laptop(type, name, brand, price, quantity, identifier, ramMemory));
					}
					}
				} else {
					System.out.println("\nO produto de ID: " + identifier + " não foi encontrado!");
				}
				
				keyPress();
				break;
					
			case 4:
				System.out.println(colors.TEXT_WHITE + "Apagar produto");
				
				System.out.println("Digite o ID do produto");
				identifier = scanner.nextInt();
				
				products.delete(identifier);
				
				keyPress();
				break;
					
			default:
				System.out.println(colors.TEXT_RED_BOLD + "\nOpção inválida!");
				
				keyPress();
				break;
			}
		}
	}

	public static void about() {
		System.out.println("******************************************************");
		System.out.println("Projeto desenvolvido por: ");
		System.out.println("Gabriella Manfredo");
		System.out.println("LinkedIn: linkedin.com/in/gabriellamanfredo/");
		System.out.println("GitHub: github.com/GabriellaManfredo");
		System.out.println("******************************************************");
	}
	
	public static void keyPress() {
		try {
			System.out.println(colors.TEXT_RESET + "\n\nPressione Enter para continuar.");
			System.in.read();

		} catch (IOException e) {
			System.err.println("Exceção: " + e);
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}
}
