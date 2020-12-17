package hw3;
/**
 * This is the main body of the chocolate objects.
 * It has two attributes in it.
 * @author Berke Can Kandemir
 */
public class Chocolate implements ICountable {
	private String name;
	private double volume;
	
	public Chocolate() {
		name = "Chocolate";
		volume = 0.5;
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
