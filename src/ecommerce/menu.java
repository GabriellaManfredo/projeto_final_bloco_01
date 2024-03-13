package ecommerce;

import java.util.Scanner;

import ecommerce.util.colors;

public class menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int option;
		
		while (true) {
			
			System.out.println(colors.TEXT_PURPLE_BRIGHT + colors.ANSI_BLACK_BACKGROUND);
			
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("                   GabsTechStore                      ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("             1 - Criar produto                        ");
			System.out.println("             2 - Listar produto                       ");              
			System.out.println("             3 - Atualizar produto                    ");
			System.out.println("             4 - Apagar produto                       ");                                 
			System.out.println("             5 - Sair                                 ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("Entre com a opção desejada:                           ");
			System.out.println("                                                      ");
			
			option = scanner.nextInt();
			
			if (option == 5) {
				System.out.println(colors.TEXT_WHITE_BOLD + "\nGabsTechStore: Inovação ao seu alcance!");
				about();
				scanner.close();
				System.exit(0);
			}
			
			switch (option) {
				case 1:
					System.out.println(colors.TEXT_WHITE + "Criar produto");
					break;
					
				case 2:
					System.out.println(colors.TEXT_WHITE + "Listar produto");
					break;
					
				case 3:
					System.out.println(colors.TEXT_WHITE + "Atualizar produto");
					break;
					
				case 4:
					System.out.println(colors.TEXT_WHITE + "Apagar produto");
					break;
					
				default:
					System.out.println(colors.TEXT_RED_BOLD + "\nOpção inválida!");
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
}
