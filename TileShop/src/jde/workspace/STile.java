/**
 * This class models a tile that is used to cover an area by square meters.
 * <p>
 * It is a {@link AbstractTile}
 * <p> 
 * @author Andrei Simion
 */
package jde.workspace;

public class STile extends AbstractTile{
	
	public STile(double price, double length, double width){
		super(price, length, width);
	}

	public double calculatePrice(double totalSurface, double price){
		return totalSurface * price;
	}
	
}