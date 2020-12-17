package hw3;
/**
 * This is the body of our factory facility.
 * @author Berke Can Kandemir
 */
public class Factory {
	private StorageArea<Chocolate> chocolateArea;
	private StorageArea<BoxedMilk> boxedMilkArea;
	private StorageArea<Yogurt> yogurtArea;
	private StorageTank<Milk> milkTank;
	private StorageTank<Cacao> cacaoTank;
	private StorageTank<Cream> creamTank;
	private StorageTank<Yeast> yeastTank;
	
	public Factory() {
		chocolateArea = new StorageArea<Chocolate>();
		boxedMilkArea = new StorageArea<BoxedMilk>();
		yogurtArea = new StorageArea<Yogurt>();
		milkTank = new StorageTank<Milk>();
		cacaoTank = new StorageTank<Cacao>();
		creamTank = new StorageTank<Cream>();
		yeastTank = new StorageTank<Yeast>();
	}
	/**
	 * Factory makes the production so, that's why we have this method in here.
	 * As in a real factory, every product has its own production method in this class.
	 * This is the one for the boxed milk products. It produces 1000L boxed milk for 1000L milk.
	 * @param milk Given raw material milk.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 */
	public void produceBoxedMilk(Milk milk) throws ItemNotCountableException {
		if (milk.getVolume() < 1000) {
			System.out.println("Not enough ingredient!");
		} else {
			milk.setVolume(0);
			for (int i = 0; i < 1000; i++) {
				if (boxedMilkArea.getCurrentVolume() < boxedMilkArea.getMaxVolume()) {
					BoxedMilk boxedMilk = new BoxedMilk();
					boxedMilkArea.add(boxedMilk);
				} else {
					System.out.println("Not enough space in the area!");
					break;
				}
			}
		}
	}
	/**
	 * Factory makes the production so, that's why we have this method in here.
	 * As in a real factory, every product has its own production method in this class.
	 * This is the one for the chocolate products. It produces 800L chocolate for 500L milk, 200L cream and 300L cacao.
	 * @param milk Given raw material milk.
	 * @param cream Given raw material cream.
	 * @param cacao Given raw material cacao.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 */
	public void produceChocolate(Milk milk, Cream cream, Cacao cacao) throws ItemNotCountableException {
		if ((milk.getVolume() < 500) || (cream.getVolume() < 200) || (cacao.getVolume() < 300)) {
			System.out.println("Not enough ingredient!");
		} else {
			milk.setVolume(0);
			cream.setVolume(0);
			cacao.setVolume(0);
			for (int i = 0; i < 1600; i++) {
				if (chocolateArea.getCurrentVolume() < chocolateArea.getMaxVolume()) {
					Chocolate chocolate = new Chocolate();
					chocolateArea.add(chocolate);
				} else {
					System.out.println("Not enough space in the area!");
					break;
				}
			}
		}
	}
	/**
	 * Factory makes the production so, that's why we have this method in here.
	 * As in a real factory, every product has its own production method in this class.
	 * This is the one for the yogurt products. It produces 1400L yogurt for 1500L milk and 100L yeast.
	 * @param milk Given raw material milk.
	 * @param yeast Given raw material yeast.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 */
	public void produceYogurt(Milk milk, Yeast yeast) throws ItemNotCountableException { 
		if ((milk.getVolume() < 1500) || (yeast.getVolume() < 100)) {
			System.out.println("Not enough ingredient!");
		} else {
			milk.setVolume(0);
			yeast.setVolume(0);
			for (int i = 0; i < 700; i++) {
				if (yogurtArea.getCurrentVolume() < yogurtArea.getMaxVolume()) {
					Yogurt yogurt = new Yogurt();
					yogurtArea.add(yogurt);
				} else {
					System.out.println("Not enough space in the area!");
					break;
				}
			}
		}
	}
	/**
	 * Factory receives the ingredient that comes from the warehouse so, that's why this method 
	 * is in this class. It simply takes the ingredient and add it to its tank.
	 * @param <T> A type parameter.
	 * @param object The arrived object to the factory.
	 */
	public <T> void receiveIngredient(T object) { 
		if (object instanceof Milk) {
			milkTank.add((Milk) object);
		} else if (object instanceof Cacao) {
			cacaoTank.add((Cacao) object);
		} else if (object instanceof Cream) {
			creamTank.add((Cream) object);
		} else if (object instanceof Yeast) {
			yeastTank.add((Yeast) object);
		}
	}
	/**
	 * As the factory ships the products, we have this method in here. It takes the product from its area to ship.
	 * @param <T> A type parameter.
	 * @param object An object that is used as a type pointer.
	 * @return <T> The removed object.
	 */
	@SuppressWarnings("unchecked")
	public <T> T shipProduct(T object) {
		if (object instanceof BoxedMilk) {
			return (T) boxedMilkArea.remove();
		} else if (object instanceof Chocolate) {
			return (T) chocolateArea.remove();
		} else if (object instanceof Yogurt) {
			return (T) yogurtArea.remove();
		} else {
			return null;
		}
	}
	/**
	 * This method is used to print out the stock status of the facility.
	 */
	public String toString() {
		System.out.println("You have " + milkTank.getAmount() + " liters of milk,");
		System.out.println("         " + cacaoTank.getAmount() + " liters of cacao,");
		System.out.println("         " + creamTank.getAmount() + " liters of cream,");
		System.out.println("         " + yeastTank.getAmount() + " liters of yeast,");
		System.out.println("         " + boxedMilkArea.getCurrentVolume() + " liters of boxed milk,");
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

	public StorageTank<Milk> getMilkTank() {
		return milkTank;
	}

	public void setMilkTank(StorageTank<Milk> milkTank) {
		this.milkTank = milkTank;
	}

	public StorageTank<Cacao> getCacaoTank() {
		return cacaoTank;
	}

	public void setCacaoTank(StorageTank<Cacao> cacaoTank) {
		this.cacaoTank = cacaoTank;
	}

	public StorageTank<Cream> getCreamTank() {
		return creamTank;
	}

	public void setCreamTank(StorageTank<Cream> creamTank) {
		this.creamTank = creamTank;
	}

	public StorageTank<Yeast> getYeastTank() {
		return yeastTank;
	}

	public void setYeastTank(StorageTank<Yeast> yeastTank) {
		this.yeastTank = yeastTank;
	}
}
