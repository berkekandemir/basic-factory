package hw3;
/**
 * This is the interface of the countable objects. Actually we use this interface to
 * create a common point between objects. So that, the methods can detect their type.
 * We researched about it and saw that it can be even an empty interface. This kind of usage 
 * is not illegal we guess according to our researches.
 * @author Berke Can Kandemir
 */
public interface ICountable {
	public double getVolume();
	public String toString();
	public String getName();
	public boolean isCountable();
}
