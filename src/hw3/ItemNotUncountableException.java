package hw3;
/**
 * This is an exception defining class.
 * @author Berke Can Kandemir
 */
@SuppressWarnings("serial")
public class ItemNotUncountableException extends Exception {
	public ItemNotUncountableException() {
		super("Item is not uncountable!");
	}
	
	public ItemNotUncountableException(String message) {
		super(message);
	}
}
