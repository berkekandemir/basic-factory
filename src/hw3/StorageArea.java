package hw3;
import java.util.LinkedList;
import java.util.Queue;
/**
 * This is the body of our storage area objects. It stores the products.
 * @author Berke Can Kandemir
 * @param <T> A type parameter
 */
public class StorageArea<T extends ICountable> {
	private double maxVolume;
	private Queue<ICountable> storageArea;
	private double currentVolume;
	
	public StorageArea() {
		maxVolume = 10000;
		storageArea = new LinkedList<ICountable>();
		currentVolume = 0;
	}
	
	public void add(T object) throws ItemNotCountableException {
		if (object instanceof ICountable) {
			if (currentVolume == maxVolume) {
				System.out.println("Area is full!");
			} else {
				storageArea.add((ICountable) object);
				currentVolume = currentVolume + object.getVolume();
			}
		} else {
			throw new ItemNotCountableException();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public T remove() {
		if (currentVolume > 0) {
			currentVolume = currentVolume - storageArea.peek().getVolume();
			return (T) storageArea.remove(); 
		} else {
			System.out.println("Storage area is empty!");
			return null;
		}
	}

	public double getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(double maxVolume) {
		this.maxVolume = maxVolume;
	}

	public Queue<ICountable> getStorageArea() {
		return storageArea;
	}

	public void setStorageArea(Queue<ICountable> storageArea) {
		this.storageArea = storageArea;
	}

	public double getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(double currentVolume) {
		this.currentVolume = currentVolume;
	}
	
	public boolean isEmpty() {
		return storageArea.isEmpty();
	}
}
