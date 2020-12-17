package hw3;
import java.util.Stack;
/**
 * This is the class of our open top container. It carries the products.
 * @author Berke Can Kandemir
 */
public class OpenTopContainer {
	private double maxVolume;
	private Stack<IUncountable> container; 
	private double currentVolume;
	
	public OpenTopContainer() {
		maxVolume = 1000;
		container = new Stack<IUncountable>();
		currentVolume = 0;
	}

	public double getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(double maxVolume) {
		this.maxVolume = maxVolume;
	}

	public Stack<IUncountable> getContainer() {
		return container;
	}

	public void setContainer(Stack<IUncountable> container) {
		this.container = container;
	}

	public <T> void push(T object) {
		if (currentVolume < maxVolume) {
			container.push((IUncountable) object);
			currentVolume++;
		} else {
			System.out.println("Not enough space in the container!");
		}
	}

	public boolean empty() {
		return container.empty();
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
