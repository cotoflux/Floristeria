package persistence;

import java.util.ArrayList;
import java.util.List;

import domain.Flower_Shop;

public class ShopRepository {

	private static List<Flower_Shop> shops;

	public ShopRepository() {
		this.shops = new ArrayList<>();
	}

	public static List<Flower_Shop> getShops() {
		return shops;
	}

	public static void setShops(List<Flower_Shop> shops) {
		ShopRepository.shops = shops;
	}

	public List<Flower_Shop> getAllShops() {
		return new ArrayList<>(shops);
	}

	public void addShop(Flower_Shop shop) throws Exception {
		if (shop == null)
			throw new Exception();
		shops.add(shop);
	}

	public void deleteShop(int position) {
		shops.remove(position);
	}

}
