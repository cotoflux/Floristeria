package application;

import java.util.Scanner;

import domain.Flower_Shop;
import persistence.ShopRepository;
import view.Menu;

public class FlowerShopController {

	private ShopRepository repositoryShops;

	private ArticleController controllerArticle;

	public FlowerShopController() {
		this.repositoryShops = new ShopRepository();
		this.controllerArticle = new ArticleController();
	}

	
	public void menuCreateFlowerShop() {

		Scanner sc = new Scanner(System.in);

		String name, adress, phone, city;
		System.out.println("Enter Name new Flower Shop. \n");
		name = sc.nextLine();
		System.out.println("Enter Adress. \n");
		adress = sc.nextLine();
		System.out.println("Enter Phone. \n");
		phone = sc.nextLine();
		System.out.println("Enter City. \n");
		city = sc.nextLine();

		try {

			createFlowerShop(name, adress, phone, city);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void createFlowerShop(String name, String adress, String phone, String city) throws Exception {
		Flower_Shop flowershop = new Flower_Shop(name, adress, phone, city);
		repositoryShops.addShop(flowershop);
		System.out.println("This Shop mas successfully created:\n" + flowershop.toString());
	}

	
	public void menuViewShops() {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		int iOption = -1;

		int iCont = repositoryShops.getAllShops().size();
		
		if (iCont == 0) {
			System.out.println("There are no shops yet in the shops network\nSelect 1. to create a shop");
		} else {
			do {
				Menu.showsShop(repositoryShops);
				try {

					iOption = sc.nextInt();
			
				} catch (Exception e) {

					iOption = sc.nextInt();
				}

				System.out.println(
						"You are selecete the Shop : " + repositoryShops.getAllShops().get(iOption - 1).getName());
			} while (iOption < 1 || iOption > iCont);


			iOption = -1;
		
			while (!exit) {

				Menu.oneShopMenu();

				System.out.println("Select one Option");
				iOption = sc.nextInt();

				try {
					switch (iOption) {

					case 1:
						// CREATE NEW ARTICLE
						controllerArticle.menuCreateArticle();
						break;

					case 2:
						// MOSTRAR ARTICULOS
						controllerArticle.menuSeeArticle();
						break;

					case 3:
						// DELETE ARTICULOS
						controllerArticle.menuDeleteArticle();
						break;

					case 4:
						System.out.println("I want to Come Back Previous Menu");
						exit = true;
						break;

					default:
						System.out.println("You must enter a number between (1,2,3,4) \n");
					}

				} catch (Exception e) {
					System.out.println("Select one Option");
					iOption = sc.nextInt();
				}

			}
		}

	}


	public void menuDeleteShop() {

		int iCont = 0;
		Scanner sc = new Scanner(System.in);
		int iOption = -1;

		for (Flower_Shop flowershop : getRepositoryShops().getAllShops()) {
			iCont++;
			System.out.println(iCont + ". " + flowershop.getName() + "\n");
		}
		if (ShopRepository.getShops().isEmpty()) {
			System.out.println("There are no shops yet in the shops network\nSelect 1. to create a shop");
		} else {
			do {
				try {
					System.out.println("Select the Shop to Delete");
					iOption = sc.nextInt();

					if (iOption < 1 || iOption > iCont) {
						System.out.println("You must choice one Shop to delete it");
					}

				} catch (Exception e) {
					System.out.println("You must enter one number.\n");// a number?
					sc.next();// ?

				}
			} while (iOption < 1 || iOption > iCont);

			iOption = iOption - 1;
			deleteShop(iOption);
		}
	}

	public void deleteShop(int position) {

		repositoryShops.deleteShop(position);

		System.out.println(
				"This Shop was successfully deleted. This are the actual shops in the network:\n" + getAllShops());
	}

	
	public int findShop() {
		int position = -1;
		for (Flower_Shop shop : ShopRepository.getShops()) {

		}
		Flower_Shop shop = null;
		return position;
	}

	
	public ShopRepository getRepositoryShops() {
		return repositoryShops;
	}

	public ArticleController getControllerArticle() {
		return controllerArticle;
	}

	
	public String getAllShops() {

		String allShops = "";
		for (Flower_Shop shop : repositoryShops.getAllShops()) {
			allShops = allShops + "\n" + shop;
		}
		return allShops;
	}

}
