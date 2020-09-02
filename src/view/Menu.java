package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Flower.Colour;
import domain.Flower_Shop;
import domain.Ornato.Material;
import persistence.ShopRepository;

public class Menu {

	public static void categorysForArticles() {

		blankLine();
		System.out.println("1. Flower");
		System.out.println("2. Tree");
		System.out.println("3. Decoration");
		System.out.println("4. Exit."); // N-not delete is exit
		blankLine();

	}

	public static void oneShopMenu() {
		blankLine();
		System.out.println("What do you want to do? : ");
		System.out.println("1. New Article");
		System.out.println("2. See Articles");
		System.out.println("3. Delete Article");
		System.out.println("4. Exit");
		blankLine();

	}

	public static void welcome() {
		System.out.println("Welcome to the Flower Shop Aplication of KEN");
		blankLine();
		System.out.println("What do you want to do? : ");
		System.out.println("1. New Shop");
		System.out.println("2. See Shop");
		System.out.println("3. Delete Shop");
		System.out.println("4. Exit");
		blankLine();
		line();
	}

	public static void blankLine() {
		System.out.println(
				"                                                                                                                         ");
	}

	public static void line() {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");
	}

	public static void doubleLine() {
		System.out.println(
				"_________________________________________________________________________________________________________________________");
		System.out.println(
				"_________________________________________________________________________________________________________________________");
	}

	public static void showsShop(ShopRepository repositoryShops) {
		int iCont = 0;
		System.out.println("SELECCIONA TIENDA");

		for (Flower_Shop shop : repositoryShops.getAllShops()) {
			iCont = iCont + 1;
			System.out.println(iCont + ". " + shop.getName());
		}

	}

	public static void showArticles() {

	}

	public static void deleteArticle() {

	}

	// k: collect name description and price of an article
	public static List<Object> collectNameDescPriceArticle() {
		List<Object> nameDescPriceList = new ArrayList<Object>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name.");
		String name = sc.nextLine();
		nameDescPriceList.add(name);

		System.out.println("Enter description.\n");
		String description = sc.nextLine();
		nameDescPriceList.add(description);
		Double pvp = -1.00;
		do {
			System.out.println("Enter PVP.");

			try {
				pvp = Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.out.println("not a correct number");
				pvp = -1.00;

			}
		} while (pvp < 0);
		nameDescPriceList.add(pvp);
		return nameDescPriceList;
	}

	// k: menu to choose enum colors Flowers
	public static void chooseColorMenu() {

		System.out.println("Enter Colour");
		System.out.println("1. " + Colour.Blue);
		System.out.println("2. " + Colour.Green);
		System.out.println("3. " + Colour.Pink);
		System.out.println("4. " + Colour.Red);
		System.out.println("5. " + Colour.White);
		System.out.println("6. " + Colour.Yellow);

	}

	// k: menu to choose enum material Decoration
	public static void chooseMaterialMenu() {
		System.out.println("Enter Material");
		System.out.println("1. " + Material.Wood);
		System.out.println("2. " + Material.Plastic);
	}
}
