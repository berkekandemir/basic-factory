package hw3;
/**
* This is the main body of the cream objects.
 * It has two attributes in it and a clone method.
 * @author Berke Can Kandemir
 */
public class Cream implements IUncountable {
	private String name;
	private double volume;
	
	public Cream() {
		name = "Cream";
		volume = 0;
	}
	
	public Cream(double volume) {
		name = "Cream";
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
	
	public Cream clone() {
		return new Cream(volume);
	}
	
	public String toString() {
		return name;
	}
	
	public boolean isCountable() {
		return false;
	}
}
