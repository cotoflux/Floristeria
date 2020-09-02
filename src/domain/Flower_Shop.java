package domain;

import java.util.ArrayList;
import java.util.List;

public class Flower_Shop {
	private String name;
	private String adress;
	private String phone;
	private String city;
	private List<AbsArticle> articleList = new ArrayList<>();

	
	public Flower_Shop(String name, String adress, String phone, String city) {
		
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return  "\n Name = "+ name + "\n Adress = "+ adress + "\n Phone = " + phone + "\n City =" + city ;
	}
	
	
}
