package hw3;
/**
 * This is the main body of the yeast objects.
 * It has two attributes in it and a clone method.
 * @author Berke Can Kandemir
 */
public class Yeast implements IUncountable {
	private String name;
	private double volume;
	
	public Yeast() {
		name = "Yeast";
		volume = 0;
	}
	
	public Yeast(double volume) {
		name = "Yeast";
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public Yeast clone() {
		return new Yeast(volume);
	}
	
	public String toString() {
		return name;
	}

	public boolean isCountable() {
		return false;
	}
}
