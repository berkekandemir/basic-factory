package hw3;
/**
 * This is the main body of the cacao objects.
 * It has two attributes in it and a clone method.
 * @author Berke Can Kandemir
 */
public class Cacao implements IUncountable {
	private String name;
	private double volume;
	
	public Cacao() {
		name = "Cacao";
		volume = 0;
	}
	
	public Cacao(double volume) {
		name = "Cacao";
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
	
	public Cacao clone() {
		return new Cacao(volume);
	}
	
	public String toString() {
		return name;
	}
	
	public boolean isCountable() {
		return false;
	}
}
