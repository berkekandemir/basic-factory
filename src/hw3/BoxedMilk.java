package hw3;
/**
 * This is the main body of the boxed milk objects.
 * It has two attributes in it.
 * @author Berke Can Kandemir
 */
public class BoxedMilk implements ICountable {
	private String name;
	private double volume;
	
	public BoxedMilk() {
		name = "BoxedMilk";
		volume = 1;
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
