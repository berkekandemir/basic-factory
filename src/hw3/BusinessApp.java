package hw3;
/**
 * This is the main class of the program.
 * In main, it only invokes the menu class' method.
 * @author Berke Can Kandemir
 *
 */
public class BusinessApp {

	public static void main(String[] args) throws ItemNotCountableException, ItemNotUncountableException, DifferentUncountableItemsException {
		BusinessAppMenu businessAppMenu = new BusinessAppMenu();
		businessAppMenu.menu();

	}

}
