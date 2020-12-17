package hw3;
/**
 * This is the main body of the yogurt objects.
 * It has two attributes in it.
 * @author Berke Can Kandemir
 */
public class Yogurt implements ICountable {
	private String name;
	private double volume;
	
	public Yogurt() {
		name = "Yogurt";
		volume = 2;
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
	public String toString() {
		return name;
	}

	public boolean isCountable() {
		return true;
	}
}
