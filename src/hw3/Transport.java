package hw3;
/**
 * This is the body of our transport operations.
 * @author Berke Can Kandemir
 */
public class Transport {
	private DryStorageContainer dryStorageContainer;
	private OpenTopContainer openTopContainer;
	private TankContainer tankContainer;
	private double capacity;
	
	public Transport() {
		dryStorageContainer = new DryStorageContainer();
		openTopContainer = new OpenTopContainer();
		tankContainer = new TankContainer();
		capacity = tankContainer.getMaxVolume();
	}
	/**
	 * In menu, we have only this method and according to the given object, it invokes
	 * the necessary method.
	 * @param <T> A type parameter.
	 * @param object Object to be added into the container.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 * @throws ItemNotUncountableException If you try to put an "countable" item into a wrong place, you get this exception.
	 * @throws DifferentUncountableItemsException If you try to put different "uncountable" items into the same place, you get this exception.
	 */
	public <T> void add(T object) throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		if ((object instanceof BoxedMilk) || (object instanceof Chocolate) || ( object instanceof Yogurt)) {
			addDryStorageContainer(object);
		} else if ((object instanceof Yeast) || (object instanceof Cacao)) {
			addOpenTopContainer(object);
		} else if ((object instanceof Milk) || (object instanceof Cream)) {
			addTankContainer(object);
		}
	}
	
	private <T> void addDryStorageContainer(T object) throws ItemNotCountableException {
		if (object instanceof ICountable) {
			dryStorageContainer.push((ICountable) object);
		} else {
			throw new ItemNotCountableException();
		}
	}
	
	private <T> void addOpenTopContainer(T object) throws ItemNotUncountableException, DifferentUncountableItemsException { 
		if (openTopContainer.empty()) {
			if (object instanceof IUncountable) {
				openTopContainer.push((IUncountable) object);
			} else {
				throw new ItemNotUncountableException();
			}
		} else {
			throw new DifferentUncountableItemsException();
		}
	}
	
	private <T> void addTankContainer(T object) throws ItemNotUncountableException, DifferentUncountableItemsException { 
		if (tankContainer.empty()) {
			if (object instanceof IUncountable) {
				tankContainer.push((IUncountable) object);
			} else {
				throw new ItemNotUncountableException();
			}
		} else {
			throw new DifferentUncountableItemsException();
		}
	}
	/**
	 * This method removes objects from the containers.
	 * @param <T> A type parameter
	 * @param object An object that is used as a type pointer.
	 * @return <T> The removed object.
	 */
	public <T> T remove(T object) { 
		if (object instanceof Milk) {
			return tankContainer.pop();
		} else if (object instanceof Cacao) {
			return openTopContainer.pop();
		} else if (object instanceof Cream) {
			return tankContainer.pop();
		} else if (object instanceof Yeast) {
			return openTopContainer.pop();
		} else if (object instanceof BoxedMilk) {
			return dryStorageContainer.pop();
		} else if (object instanceof Chocolate) {
			return dryStorageContainer.pop();
		} else if (object instanceof Yogurt) {
			return dryStorageContainer.pop();
		} else {
			return null;
		}
	}
	
	public double getTransportCapacity() {
		return capacity;
	}
}
