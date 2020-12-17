package hw3;
import java.util.Stack;
/**
 * This is the class of our dry storage container. It carries the products.
 * @author Berke Can Kandemir
 */
public class DryStorageContainer {
	private double maxVolume;
	private Stack<ICountable> container; 
	private double currentVolume;
	
	public DryStorageContainer() {
		maxVolume = 1000;
		container = new Stack<ICountable>();
		currentVolume = 0;
	}

	public double getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(double maxVolume) {
		this.maxVolume = maxVolume;
	}

	public Stack<ICountable> getContainer() {
		return container;
	}

	public void setContainer(Stack<ICountable> container) {
		this.container = container;
	}
	
	public <T> void push(T object) {
		if (currentVolume < maxVolume) {
			container.push((ICountable) object);
			currentVolume = currentVolume + ((ICountable) object).getVolume();
		} else {
			System.out.println("Not enough space in the container!");
		}
	}
	
	public double size() {
		return currentVolume;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T pop() {
		currentVolume = currentVolume - container.peek().getVolume();
		return (T) container.pop();
	}
}
