package domain;

public class Ornato extends AbsArticle{
	


public static enum Material {
		  Plastic,
		  Wood,
		  Undefined
		}
	Material mat;


	public Ornato( String name, String description, double pvp,  Material mat) {
		super(name, description, pvp);
		this.mat=mat.Wood;
		
	}
	@Override
	public String toString() {
		return "Ornato [mat=" + mat +  ", name=" + name + ", description=" + description + ", pvp=" + pvp
				+ "]";
	}

}
