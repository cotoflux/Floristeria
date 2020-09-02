package domain;

public class Tree extends AbsArticle{
	
	protected int height;

	public Tree( String name, String description, double pvp, int height) {
		super( name, description, pvp);
		this.height=height;
	}

	@Override
	public String toString() {
		return "Tree [height=" + height + ", name=" + name + ", description=" + description + ", pvp="
				+ pvp + "]";
	}

	
}
