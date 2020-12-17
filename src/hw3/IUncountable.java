package hw3;
/**
 * This is the interface of the uncountable objects. Actually we use this interface to
 * create a common point between objects. So that, the methods can detect their type.
 * We researched about it and saw that it can be even an empty interface. This kind of usage 
 * is not illegal we guess according to our researches.
 * On the other hand, clone and getVolume methods have to be here anyway.
 * @author Berke Can Kandemir
 */
public interface IUncountable {
	public double getVolume();
	public IUncountable clone();
	public void setVolume(double volume);
	public String getName();
	public String toString();
	public boolean isCountable();
}
