package hw3;
/**
 * This is the body of our warehouse facility.
 * @author Berke Can Kandemir
 */
public class Warehouse {
	private StorageTank<Milk> milkTank;
	private StorageTank<Cacao> cacaoTank;
	private StorageTank<Cream> creamTank;
	private StorageTank<Yeast> yeastTank;
	
	public Warehouse() {
		milkTank = new StorageTank<Milk>();
		cacaoTank = new StorageTank<Cacao>();
		creamTank = new StorageTank<Cream>();
		yeastTank = new StorageTank<Yeast>();
	}
	/**
	 * As the buy operation for ingredients happens in the warehouse, we put this method in here.
	 * It buys the desired amount of the desired object.
	 * @param <T> A type parameter.
	 * @param object An object that is used as a type pointer.
	 * @param amount The desired amount to buy the ingredient.
	 */
	public <T> void buyIngredient(T object, double amount) { 
		if (object instanceof Milk) {
			Milk milk = new Milk(amount);
			milkTank.add(milk);
		} else if (object instanceof Cacao) {
			Cacao cacao = new Cacao(amount);
			cacaoTank.add(cacao);
		} else if (object instanceof Cream) {
			Cream cream = new Cream(amount);
			creamTank.add(cream);
		} else if (object instanceof Yeast) {
			Yeast yeast = new Yeast(amount);
			yeastTank.add(yeast);
		}
	}
	/**
	 * As the shipping of the ingredients happens in the warehouse, we put this method in here.
	 * It removes the ingredients from the storage tanks in the desired amount or the container capacity.
	 * @param <T> A type parameter.
	 * @param object An object that is used as a type pointer.
	 * @param amount The desired amount of ingredient to be shipped.
	 * @return <T> The removed object.
	 */
	@SuppressWarnings("unchecked")
	public <T> T shipIngredient(T object, double amount) {
		if (object instanceof Milk) {
			return (T) milkTank.remove(amount);
		} else if (object instanceof Cacao) {
			return (T) cacaoTank.remove(amount);
		} else if (object instanceof Cream) {
			return (T) creamTank.remove(amount);
		} else if (object instanceof Yeast) {
			return (T) yeastTank.remove(amount);
		} else {
			return null;
		}
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
	/**
	 * This method is used to print out the stock status of the facility.
	 */
	public String toString() {
		System.out.println("You have " + milkTank.getAmount() + " liters of milk,");
		System.out.println("         " + cacaoTank.getAmount() + " liters of cacao,");
		System.out.println("         " + creamTank.getAmount() + " liters of cream,");
		System.out.println("         " + yeastTank.getAmount() + " liters of yeast.");
		return "";
	}
}
