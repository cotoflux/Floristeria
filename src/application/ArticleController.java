package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//--------------
import domain.AbsArticle;
import domain.Flower;
import domain.Flower.Colour;
import domain.Ornato;
import domain.Ornato.Material;
import domain.Tree;
import persistence.ArticleRepository;
import view.Menu;

public class ArticleController {

	private ArticleRepository repositoryArticles;

	// k:create list with articles
	public ArticleController() {
		this.repositoryArticles = new ArticleRepository();
	}

	// k: menu to create an article
	public void menuCreateArticle() {
		int choice;
		do {
			System.out.println("please choose a number between 1 and 4");
			Menu.categorysForArticles();
			Scanner sc = new Scanner(System.in);
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("you did not put in an number");
				choice = 0;
			}
		} while (!(choice == 1 || choice == 2 || choice == 3 || choice == 4));

		switch (choice) {
		case 1:
			createFlower();
			break;
		case 2:
			createTree();
			break;
		case 3:
			createOrnato();
			break;
		case 4:
			break;
		}
	}

	// k:menu to see article
	public void menuSeeArticle() {

		if (repositoryArticles.getArticles().size() == 0) {
			System.out.println("There isn't any article in this store. \n");
		} else {

			System.out.println("these are the articles in this store:\n");
			for (AbsArticle article : repositoryArticles.getArticles()) {
				System.out.println(article);
			}
		}
	}

	public void menuDeleteArticle() {

		// k:menu to delete article
		int iCont = 1;
		Scanner sc = new Scanner(System.in);

		if (repositoryArticles.getArticles().size() == 0) {
			System.out.println("There isn't any article to delete in this store. \n");
		} else {

			for (AbsArticle article : repositoryArticles.getArticles()) {
				System.out.println(iCont + ". " + article + "\n");
				iCont++;
			}
			System.out.println("Select one article to delete");
			int iOption = sc.nextInt();
			deleteArticle(iOption - 1);
		}
	}

	// k:delete 1 article
	public void deleteArticle(int position) {
		repositoryArticles.deleteArticle(position);
		System.out.println("This article was successfully deleted. These are the actual articles in the shop:\n"
				+ repositoryArticles.getArticles());
	}


	// k: collect name description and price of an article
	public List<Object> collectNameDescPriceArticle() {
		List<Object> nameDescPriceList = new ArrayList<Object>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name.");
		String name = sc.nextLine();
		nameDescPriceList.add(name);

		System.out.println("Enter description.\n");
		String description = sc.nextLine();
		nameDescPriceList.add(description);

		System.out.println("Enter PVP.");
		Double pvp = Double.parseDouble(sc.nextLine());
		nameDescPriceList.add(pvp);

		// sc.close();

		return nameDescPriceList;

	}


	// k: create a flower
	public void createFlower() {

		// collecting name description and

		List<Object> articleNameDescPrice = Menu.collectNameDescPriceArticle();
		String name = (String) articleNameDescPrice.get(0);
		String description = (String) articleNameDescPrice.get(1);
		Double pvp = (Double) articleNameDescPrice.get(2);

		int choice = 0;
		Colour colour;

		do {
			Scanner sc = new Scanner(System.in);
			Menu.chooseColorMenu();
			choice = sc.nextInt();
			System.out.println("please choose between 1 and 6"); //N - there is only 6 options no 7

/*
		List<Object> articleNameDescPrice = collectNameDescPriceArticle();
		String name = (String) articleNameDescPrice.get(0);
		String description = (String) articleNameDescPrice.get(1);
		Double pvp = (Double) articleNameDescPrice.get(2);
		int choice = 0;
		Colour colour;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Colour");
			System.out.println("1. " + Colour.Blue);
			System.out.println("2. " + Colour.Green);
			System.out.println("3. " + Colour.Pink);
			System.out.println("4. " + Colour.Red);
			System.out.println("5. " + Colour.White);
			System.out.println("6. " + Colour.Yellow);

			choice = sc.nextInt();

			System.out.println("please choose between 1,and 7");
*/
		} while ((choice < 1 || choice > 6));

		switch (choice) {
		case 1:
			colour = Colour.Blue;
			break;
		case 2:
			colour = Colour.Green;
			break;
		case 3:
			colour = Colour.Pink;
			break;
		case 4:
			colour = Colour.Red;
			break;
		case 5:
			colour = Colour.White;
			break;
		case 6:
			colour = Colour.Yellow;
			break;

		default:
			colour = Colour.Undefined;
			break;
		}

		try {
			AbsArticle flower = new Flower(name, description, pvp, colour);
			repositoryArticles.addArticle(flower);
			System.out.println("you created a flower:\n" + flower);
		} catch (Exception e) {
		}
	}

	// k: create a tree
	public void createTree() {

		List<Object> articleNameDescPrice = Menu.collectNameDescPriceArticle();
/*
		List<Object> articleNameDescPrice = collectNameDescPriceArticle();
*/
		String name = (String) articleNameDescPrice.get(0);
		String description = (String) articleNameDescPrice.get(1);
		Double pvp = (Double) articleNameDescPrice.get(2);

		Scanner sc = new Scanner(System.in);

		System.out.println("height tree please");
		int height = Integer.parseInt(sc.nextLine());

		try {
			AbsArticle tree = new Tree(name, description, pvp, height);
			repositoryArticles.addArticle(tree);
			System.out.println("you created a tree:\n" + tree);

		} catch (Exception e) {
		}

	}

	// k: create a decoration
	public void createOrnato() {

		List<Object> articleNameDescPrice = Menu.collectNameDescPriceArticle();
/*
		List<Object> articleNameDescPrice = collectNameDescPriceArticle();
*/
		String name = (String) articleNameDescPrice.get(0);
		String description = (String) articleNameDescPrice.get(1);
		Double pvp = (Double) articleNameDescPrice.get(2);

		int choice;
		Material material = null;
		do {
			Scanner sc = new Scanner(System.in);

			Menu.chooseMaterialMenu();

			System.out.println("Enter Material");
			System.out.println("1. " + Material.Wood);
			System.out.println("2. " + Material.Plastic);

			choice = Integer.parseInt(sc.nextLine());

		} while (!(choice == 1 || choice == 2));
		switch (choice) {
		case 1:
			material = Material.Wood;
			break;
		case 2:
			material = Material.Plastic;
			break;
		}
		try {
			AbsArticle ornato = new Ornato(name, description, pvp, material);
			repositoryArticles.addArticle(ornato);
			System.out.println("you created a decoration:\n" + ornato);
		} catch (Exception e) {
		}
	}
}
