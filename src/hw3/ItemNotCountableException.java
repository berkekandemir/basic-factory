package hw3;
/**
 * This is an exception defining class.
 * @author Berke Can Kandemir
 */
@SuppressWarnings("serial")
public class ItemNotCountableException extends Exception {
	
	public ItemNotCountableException() {
		super("Item is not countable!");
	}
	
	public ItemNotCountableException(String message) {
		super(message);
	}
}
