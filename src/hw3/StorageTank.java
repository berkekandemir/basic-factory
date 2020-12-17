package hw3;
import java.util.*;
/**
 * This is the body of our storage tank objects. It stores the ingredients.
 * @author Berke Can Kandemir
 * @param <T> A type parameter
 */
public class StorageTank<T extends IUncountable> {
	private double maxVolume;
	private double amount;
	private List<T> storageTank;
	
	public StorageTank() {
		maxVolume = 10000;
		amount = 0;
		storageTank = new ArrayList<T>();
	}

	public double getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(double maxVolume) {
		this.maxVolume = maxVolume;
	}

	public double getAmount() {
		if (storageTank.isEmpty()) {
			return 0;
		} else {
			return storageTank.get(0).getVolume();
		}
	}

	public void setAmount(double amount) {
		this.amount = amount;
		storageTank.get(0).setVolume(amount);
	}

	public List<T> getItem() {
		return storageTank;
	}

	public void setItem(List<T> storageTank) {
		this.storageTank = storageTank;
	}
	
	public void add(T object) {
		double volume = object.getVolume();
		if (volume <= (maxVolume - amount)) {
			amount = amount + volume;
			object.setVolume(amount);
			if (storageTank.size() == 0) {
				storageTank.add(object);
			} else {
				storageTank.set(0, object);
			}
		} else {
			volume = maxVolume - amount;
			amount = amount + volume;
			object.setVolume(amount);
			if (storageTank.size() == 0) {
				storageTank.add(object);
			} else {
				storageTank.set(0, object);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T remove(double amount) {
		if (amount >= storageTank.get(0).getVolume()) {
			amount = storageTank.get(0).getVolume();
			T newItem = storageTank.get(0);
			T itemToReturn = (T) newItem.clone();
			storageTank.get(0).setVolume(newItem.getVolume() - amount);;
			return itemToReturn;
		} else {
			T newItem = storageTank.get(0);
			T itemToReturn = (T) newItem.clone();
			itemToReturn.setVolume(1000);
			storageTank.get(0).setVolume(newItem.getVolume() - amount);
			return itemToReturn;
		}
	}
	
	public boolean isEmpty() {
		return storageTank.isEmpty();
	}
}
