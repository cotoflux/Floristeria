package domain;

public abstract class AbsArticle {
	protected String name;
	protected String description;
	protected double pvp;

	public AbsArticle(String name, String description, double pvp) {

		this.name = name;
		this.description = description;
		this.pvp = pvp;
	}

	public String getName() {
		return name;
	}

}
