package hw3;

import java.util.Scanner;
/**
 * This is the menu class. In this class, program uses the objects and
 * according to the user choices performs the operations.
 * @author Berke Can Kandemir
 *
 */
public class BusinessAppMenu {
	/**
	 * These are the necessary object we use in the methods.
	 * It looks too many at first but, actually the half of them are for the reusability.
	 */
	private Warehouse warehouse;
	private Factory factory;
	private DistributionCenter distributionCenter;
	private Transport transport;
	private Safebox safebox;
	private Scanner keyboard;
	private int transportFee;
	private double milkCost;
	private double creamCost;
	private double cacaoCost;
	private double yeastCost;
	private double boxedMilkCost;
	private double chocolateCost;
	private double yogurtCost;
	private double transportCapacity;
	
	public BusinessAppMenu() {
		warehouse = new Warehouse();
		factory = new Factory();
		distributionCenter = new DistributionCenter();
		transport = new Transport();
		safebox = new Safebox();
		keyboard = new Scanner(System.in);
		transportFee = 100; 
		milkCost = 0.25;
		creamCost = 0.30;
		cacaoCost = 1;
		yeastCost = 5;
		boxedMilkCost = 1;
		chocolateCost = 4;
		yogurtCost = 2;
		transportCapacity = transport.getTransportCapacity();
	}
	/**
	 * This method is the main part of the class. It calls the necessary methods
	 * according to the user choices. We could make all operations in one method but,
	 * we wanted to make it modular to be able to change it easily in the future.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 * @throws ItemNotUncountableException If you try to put an "countable" item into a wrong place, you get this exception.
	 * @throws DifferentUncountableItemsException If you try to put different "uncountable" items into the same place, you get this exception.
	 */
	public void menu() throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		System.out.println("* * * Welcome to the Company * * *");
		boolean exit = false;
		while (!exit) {
			System.out.println("");
			System.out.println("You have " + safebox.getAmount() + " TL in company safebox.");
			System.out.println("");
			System.out.println("1- See the stock pile");
			System.out.println("2- Buy ingredients");
			System.out.println("3- Produce products");
			System.out.println("4- Sell products");
			System.out.println("5- Transport ingredients or products");
			System.out.println("0- To exit");
			System.out.println("");
			System.out.print("Select the option you want to perform: ");
			int choice = keyboard.nextInt();
			if (choice == 1) {
				seeStockPile();
			} else if (choice == 2) {
				buyIngredients();
			} else if (choice == 3) {
				produceProducts();
			} else if (choice == 4) {
				sellProducts();
			} else if (choice == 5) {
				transportItems();
			} else if (choice == 0) {
				exit = true;
			} else {
				System.out.println("");
				System.out.println("Wrong input!");
			}
			transportCapacity = transport.getTransportCapacity();
		}
	}
	/**
	 * This method prints out the stock status in the facilities to the screen.
	 * It uses the facilities' toString method.
	 */
	private void seeStockPile() {
		System.out.println("");
		System.out.println("1- See the stock pile at the Warehouse");
		System.out.println("2- See the stock pile at the Factory");
		System.out.println("3- See the stock pile at the Distribution Center");
		System.out.println("");
		System.out.print("Select the facility: ");
		int choice = keyboard.nextInt();
		System.out.println("");
		if (choice == 1) {
			System.out.println(warehouse);
		} else if (choice == 2) {
			System.out.println(factory);
		} else if (choice == 3) {
			System.out.println(distributionCenter);
		} else {
			System.out.println("Wrong input!");
		}
	}
	/**
	 * This method makes the buying operation according to the user choice. User chooses the material
	 * to buy and the method makes the operations according to the chosen material.
	 * It checks if the money is enough or not. If it is enough, it buys the desired material in the desired amount
	 * as long as it is not greater than the tank capacity.
	 */
	private void buyIngredients() {
		System.out.println("");
		System.out.println("1- Buy milk (" + milkCost + " TL/L)");
		System.out.println("2- Buy cacao (" + cacaoCost + " TL/L)");
		System.out.println("3- Buy cream (" + creamCost + " TL/L)");
		System.out.println("4- Buy yeast (" + yeastCost + " TL/L)");
		System.out.println("");
		System.out.print("Select the ingredient you want to buy: ");
		int choice = keyboard.nextInt();
		System.out.println("");
		System.out.print("Enter the amount you want to buy (Liter): ");
		int amount = keyboard.nextInt();
		System.out.println("");
		if (choice == 1) {
			Milk milk = new Milk();
			double cost = milkCost * amount;
			if (safebox.getAmount() >= cost) {
				warehouse.buyIngredient(milk, amount);
				safebox.setAmount(safebox.getAmount() - cost);
				System.out.println("Successfully bought!");
			} else {
				System.out.println("Insufficient money!");
			}
		} else if (choice == 2) {
			Cacao cacao = new Cacao();
			double cost = cacaoCost * amount;
			if (safebox.getAmount() >= cost) {
				warehouse.buyIngredient(cacao, amount);
				safebox.setAmount(safebox.getAmount() - cost);
				System.out.println("Successfully bought!");
			} else {
				System.out.println("Insufficient money!");
			}
		} else if (choice == 3) {
			Cream cream = new Cream();
			double cost = creamCost * amount;
			if (safebox.getAmount() >= cost) {
				warehouse.buyIngredient(cream, amount);
				safebox.setAmount(safebox.getAmount() - cost);
				System.out.println("Successfully bought!");
			} else {
				System.out.println("Insufficient money!");
			}
		} else if (choice == 4) {
			Yeast yeast = new Yeast();
			double cost = yeastCost * amount;
			if (safebox.getAmount() >= cost) {
				warehouse.buyIngredient(yeast, amount);
				safebox.setAmount(safebox.getAmount() - cost);
				System.out.println("Successfully bought!");
			} else {
				System.out.println("Insufficient money!");
			}
		} else {
			System.out.println("Wrong input!");
		}
		
	}
	/**
	 * This method makes the production operations. The production amount and the input amounts are fixed.
	 * So, if the factory has enough raw material to produce the desired product in the fixed amount,
	 * method does the operations.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 */
	private void produceProducts() throws ItemNotCountableException {
		System.out.println("");
		System.out.println("1- Produce 1000L boxed milk (Requires 1000L milk)");
		System.out.println("2- Produce 800L chocolate (Requires 500L milk, 200L cream, 300L cacao)");
		System.out.println("3- Produce 1400L yogurt (Requires 1500L milk, 100L yeast)");
		System.out.println("");
		System.out.print("Select the product you want to produce: ");
		int choice = keyboard.nextInt();
		System.out.println("");
		if (choice == 1) {
			if (factory.getMilkTank().getAmount() >= 1000) {
				Milk milk = factory.getMilkTank().remove(1000);
				factory.produceBoxedMilk(milk);
				System.out.println("Successfully produced!");
			} else {
				System.out.println("Insufficient raw material!");
			}
		} else if (choice == 2) {
			if ((factory.getMilkTank().getAmount() >= 500) && (factory.getCreamTank().getAmount() >= 200) && (factory.getCacaoTank().getAmount() >= 300)) {
				Milk milk = factory.getMilkTank().remove(500);
				Cream cream = factory.getCreamTank().remove(200);
				Cacao cacao = factory.getCacaoTank().remove(300);
				factory.produceChocolate(milk, cream, cacao);
				System.out.println("Successfully produced!");
			} else {
				System.out.println("Insufficient raw material!");
			}
		} else if (choice  == 3) {
			if ((factory.getMilkTank().getAmount() >= 1500) && (factory.getYeastTank().getAmount() >= 100)) {
				Milk milk = factory.getMilkTank().remove(1500);
				Yeast yeast = factory.getYeastTank().remove(100);
				factory.produceYogurt(milk, yeast);
				System.out.println("Successfully produced!");
			} else {
				System.out.println("Insufficient raw material!");
			}
		} else {
			System.out.println("Wrong input!");
		}
		
	}
	/**
	 * This method makes the sell operations. If the distribution center has the user's entered amount of chosen product,
	 * method sells the product.
	 */
	private void sellProducts() {
		System.out.println("");
		System.out.println("1- Sell boxed milk (" + boxedMilkCost + " TL/L)");
		System.out.println("2- Sell chocolate (" + chocolateCost + " TL/L)");
		System.out.println("3- Sell yogurt (" + yogurtCost + " TL/L)");
		System.out.println("");
		System.out.print("Select the product you want to sell: ");
		int choice = keyboard.nextInt();
		System.out.println("");
		System.out.print("Select the amount you want to sell (Liter): ");
		int amount = keyboard.nextInt();
		System.out.println("");
		if (choice == 1) {
			if (distributionCenter.getBoxedMilkArea().getCurrentVolume() >= amount) {
				for (int i = 0; i < amount; i++) {
					distributionCenter.getBoxedMilkArea().remove();
					safebox.setAmount(safebox.getAmount() + boxedMilkCost);
				}
			} else {
				System.out.println("Insufficient product!");
			}
		} else if (choice == 2) {
			if (distributionCenter.getChocolateArea().getCurrentVolume() >= amount) {
				for (int i = 0; i < (amount * 2); i++) {
					distributionCenter.getChocolateArea().remove();
					safebox.setAmount(safebox.getAmount() + (chocolateCost / 2));
				}
			} else {
				System.out.println("Insufficient product!");
			}
		} else if (choice == 3) {
			if (distributionCenter.getYogurtArea().getCurrentVolume() >= amount) {
				for (int i = 0; i < (amount / 2); i++) {
					distributionCenter.getYogurtArea().remove();
					safebox.setAmount(safebox.getAmount() + (yogurtCost * 2));
				}
			} else {
				System.out.println("Insufficient product!");
			}
		} else {
			System.out.println("Wrong input!");
		}
		
	}
	/**
	 * This method makes the transportation operations between facilities. It invokes the necessary method 
	 * according to the user's choice.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 * @throws ItemNotUncountableException If you try to put an "countable" item into a wrong place, you get this exception.
	 * @throws DifferentUncountableItemsException If you try to put different "uncountable" items into the same place, you get this exception.
	 */
	private void transportItems() throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		System.out.println("");
		System.out.println("1- Ship from warehouse to factory");
		System.out.println("2- Ship from factory to distribution center");
		System.out.println("");
		System.out.println("Transport fee is " + transportFee + " TL for one way trip.");
		System.out.println("");
		System.out.print("Select the places you want to ship between: ");
		int choice = keyboard.nextInt();
		if (safebox.getAmount() >= transportFee) {
			if (choice == 1) {
				fromWarehouseToFactory();
			} else if (choice == 2) {
				fromFactoryToDistributionCenter();
			}
		} else {
			System.out.println("Insufficient money!");
		}
	}
	/**
	 * This method works like that; first asks for the user choice, then according to the choice, it 
	 * loads the necessary container with the chosen product as long as the container is empty or the storage tank gets empty.
	 * Then, it takes the one way shipment fee. Then, it unloads the container in the factory. Lastly, takes the one way fee again
	 * and it is ready to deliver another shipment from warehouse to the factory.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 * @throws ItemNotUncountableException If you try to put an "countable" item into a wrong place, you get this exception.
	 * @throws DifferentUncountableItemsException If you try to put different "uncountable" items into the same place, you get this exception.
	 */
	private void fromWarehouseToFactory() throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		System.out.println("");
		System.out.println("1- Milk");
		System.out.println("2- Cacao");
		System.out.println("3- Cream");
		System.out.println("4- Yeast");
		System.out.println("");
		System.out.print("Select the ingredient you want to ship: ");
		int type = keyboard.nextInt();
		System.out.println("");
		if (type == 1) {
			if (warehouse.getMilkTank().isEmpty()) {
				System.out.println("Insufficient raw material!");
			} else {
				if (warehouse.getMilkTank().getAmount() >= transportCapacity) {
					Milk typePointer = new Milk();
					Milk milkToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(milkToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else if (warehouse.getMilkTank().getAmount() < transportCapacity) {
					transportCapacity = warehouse.getMilkTank().getAmount();
					Milk typePointer = new Milk();
					Milk milkToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(milkToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else {
					System.out.println("Insufficient raw material!");
				}
			}
		} else if (type == 2) {
			if (warehouse.getCacaoTank().isEmpty()) {
				System.out.println("Insufficient raw material!");
			} else {
				if (warehouse.getCacaoTank().getAmount() >= transportCapacity) {
					Cacao typePointer = new Cacao();
					Cacao cacaoToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(cacaoToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else if (warehouse.getCacaoTank().getAmount() < transportCapacity) {
					transportCapacity = warehouse.getCacaoTank().getAmount();
					Cacao typePointer = new Cacao();
					Cacao cacaoToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(cacaoToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else {
					System.out.println("Insufficient raw material!");
				}
			}
		} else if (type == 3) {
			if (warehouse.getCreamTank().isEmpty()) {
				System.out.println("Insufficient raw material!");
			} else {
				if (warehouse.getCreamTank().getAmount() >= transportCapacity) {
					Cream typePointer = new Cream();
					Cream creamToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(creamToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else if (warehouse.getCreamTank().getAmount() < transportCapacity) {
					transportCapacity = warehouse.getCreamTank().getAmount();
					Cream typePointer = new Cream();
					Cream creamToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(creamToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else {
					System.out.println("Insufficient raw material!");
				}
			}
		} else if (type == 4) {
			if (warehouse.getYeastTank().isEmpty()) {
				System.out.println("Insufficient raw material!");
			} else {
				if (warehouse.getYeastTank().getAmount() >= transportCapacity) {
					Yeast typePointer = new Yeast();
					Yeast yeastToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(yeastToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else if (warehouse.getYeastTank().getAmount() < transportCapacity) {
					Yeast typePointer = new Yeast();
					Yeast yeastToShip = warehouse.shipIngredient(typePointer, transportCapacity);
					transport.add(yeastToShip);
					safebox.setAmount(safebox.getAmount() - transportFee);
					factory.receiveIngredient(transport.remove(typePointer));
					safebox.setAmount(safebox.getAmount() - transportFee);
				} else {
					System.out.println("Insufficient raw material!");
				}
			}
		} else {
			System.out.println("Wrong input!");
		}
	}
	/**
	 * This method works like that; first asks for the user choice, then according to the choice, it 
	 * loads the necessary container with the chosen product as long as the container is empty or the storage area gets empty.
	 * Then, it takes the one way shipment fee. Then, it unloads the container in the distribution center. Lastly, takes the one way fee again
	 * and it is ready to deliver another shipment from factory to the distribution center.
	 * @throws ItemNotCountableException If you try to put an "uncountable" item into a wrong place, you get this exception.
	 * @throws ItemNotUncountableException If you try to put an "countable" item into a wrong place, you get this exception.
	 * @throws DifferentUncountableItemsException If you try to put different "uncountable" items into the same place, you get this exception.
	 */
	public void fromFactoryToDistributionCenter() throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		System.out.println("");
		System.out.println("1- Boxed Milk");
		System.out.println("2- Chocolate");
		System.out.println("3- Yogurt");
		System.out.println("");
		System.out.print("Select the product you want to ship: ");
		int type = keyboard.nextInt();
		System.out.println("");
		if (type == 1) {
			if (factory.getBoxedMilkArea().isEmpty()) {
				System.out.println("Insufficient product!");
			} else {
				BoxedMilk typePointer = new BoxedMilk();
				if (factory.getBoxedMilkArea().getCurrentVolume() < transportCapacity) {
					transportCapacity = factory.getBoxedMilkArea().getCurrentVolume();
				}
				for (int i = 0; i < transportCapacity; i++) {
					BoxedMilk boxedMilkToShip = factory.getBoxedMilkArea().remove();
					transport.add(boxedMilkToShip);
				}
				safebox.setAmount(safebox.getAmount() - transportFee);
				for (int i = 0; i < transportCapacity; i++) {
					distributionCenter.receiveProduct(transport.remove(typePointer));
				}
				safebox.setAmount(safebox.getAmount() - transportFee);
			}
		} else if (type == 2) {
			if (factory.getChocolateArea().isEmpty()) {
				System.out.println("Insufficient product!");
			} else {
				Chocolate typePointer = new Chocolate();
				if (factory.getChocolateArea().getCurrentVolume() < transportCapacity) {
					transportCapacity = factory.getChocolateArea().getCurrentVolume();
				}
				for (int i = 0; i < (transportCapacity * 2); i++) {
					Chocolate chocolateToShip = factory.getChocolateArea().remove();
					transport.add(chocolateToShip);
					
				}
				safebox.setAmount(safebox.getAmount() - transportFee);
				for (int i = 0; i < (transportCapacity * 2); i++) {
					distributionCenter.receiveProduct(transport.remove(typePointer));
					
				}
				safebox.setAmount(safebox.getAmount() - transportFee);
			}
		} else if (type == 3) {
			if (factory.getYogurtArea().isEmpty()) {
				System.out.println("Insufficient product!");
			} else {
				Yogurt typePointer = new Yogurt();
				if (factory.getYogurtArea().getCurrentVolume() < transportCapacity) {
					transportCapacity = factory.getYogurtArea().getCurrentVolume();
				}
				for (int i = 0; i < (transportCapacity / 2); i++) {
					Yogurt yogurtToShip = factory.getYogurtArea().remove();
					transport.add(yogurtToShip);
				}
				safebox.setAmount(safebox.getAmount() - transportFee);
				for (int i = 0; i < (transportCapacity / 2); i++) {
					distributionCenter.receiveProduct(transport.remove(typePointer));
				}
				safebox.setAmount(safebox.getAmount() - transportFee);
			}
		} else {
			System.out.println("Wrong input!");
		}
	}
}
