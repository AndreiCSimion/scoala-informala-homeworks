/**
 * This interface defines the methods used.
 * 
 * @author Andrei Simion
 */
package jde.workspace;

public interface Tile{
	public double calculatePrice(double totalSurface, double price);
	public double calculateArea();
	public double calculatePTArea();


}