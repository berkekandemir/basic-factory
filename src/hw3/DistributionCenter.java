package hw3;
/**
 * This is the body of our distribution center facility.
 * @author Berke Can Kandemir
 */
public class DistributionCenter {
	private StorageArea<Chocolate> chocolateArea;
	private StorageArea<BoxedMilk> boxedMilkArea;
	private StorageArea<Yogurt> yogurtArea;
	
	public DistributionCenter() {
		chocolateArea = new StorageArea<Chocolate>();
		boxedMilkArea = new StorageArea<BoxedMilk>();
		yogurtArea = new StorageArea<Yogurt>();
	}
	/**
	 * Sell operation happens at the distribution center so, that's why we put this method into this class.
	 * @param <T> A type parameter
	 * @param object An object that is used as a type pointer.
	 */
	public <T> void sellProduct(T object) { 
		if (object instanceof Chocolate) {
			chocolateArea.remove();
		} else if (object instanceof BoxedMilk) {
			boxedMilkArea.remove();
		} else if (object instanceof Yogurt) {
			yogurtArea.remove();
		}
	}
	/**
	 * Distribution center receives the product which comes from the factory so, that's why we put
	 * this method into this class.
	 * @param <T> A type parameter
	 * @param object Object to be added into its area
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 */
	public <T> void receiveProduct(T object) throws ItemNotCountableException {
		if (object instanceof Chocolate) {
			chocolateArea.add((Chocolate) object);
		} else if (object instanceof BoxedMilk) {
			boxedMilkArea.add((BoxedMilk) object);
		} else if (object instanceof Yogurt) {
			yogurtArea.add((Yogurt) object);
		}
	}
	/**
	 * This method is used to print out the stock status of the facility.
	 */
	public String toString() {
		System.out.println("You have " + boxedMilkArea.getCurrentVolume() + " liters of boxed milk,");
		System.out.println("         " + chocolateArea.getCurrentVolume() + " liters of chocolate,");
		System.out.println("         " + yogurtArea.getCurrentVolume() + " liters of yogurt.");
		return "";
	}

	public StorageArea<Chocolate> getChocolateArea() {
		return chocolateArea;
	}

	public void setChocolateArea(StorageArea<Chocolate> chocolateArea) {
		this.chocolateArea = chocolateArea;
	}

	public StorageArea<BoxedMilk> getBoxedMilkArea() {
		return boxedMilkArea;
	}

	public void setBoxedMilkArea(StorageArea<BoxedMilk> boxedMilkArea) {
		this.boxedMilkArea = boxedMilkArea;
	}

	public StorageArea<Yogurt> getYogurtArea() {
		return yogurtArea;
	}

	public void setYogurtArea(StorageArea<Yogurt> yogurtArea) {
		this.yogurtArea = yogurtArea;
	}
}
