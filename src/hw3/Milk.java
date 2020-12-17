package hw3;
/**
 * This is the main body of the milk objects.
 * It has two attributes in it and a clone method.
 * @author Berke Can Kandemir
 */
public class Milk implements IUncountable {
	private String name;
	private double volume;
	
	public Milk() {
		name = "Milk";
		volume = 0;
	}
	
	public Milk(double volume) {
		name = "Milk";
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
	
	public Milk clone() {
		return new Milk(volume);
	}
	
	public String toString() {
		return name;
	}
	
	public boolean isCountable() {
		return false;
	}
}
