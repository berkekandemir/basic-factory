package hw3;
/**
 * This is an exception defining class.
 * @author Berke Can Kandemir
 */
@SuppressWarnings("serial")
public class DifferentUncountableItemsException extends Exception{
	public DifferentUncountableItemsException() {
		super("This is a different type of uncountable item!");
	}
	
	public DifferentUncountableItemsException(String message) {
		super(message);
	}
}
