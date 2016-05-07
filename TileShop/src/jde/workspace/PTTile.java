/**
 * This class models a tile that is used to cover an area by pieces of triangular shape.
 * <p>
 * It extends from a {@link AbstractTile}
 * <p>
 * @author Andrei Simion
 */
package jde.workspace;

public class PTTile extends AbstractTile{
		
	public PTTile(double hypo, double price){
		super(hypo, price);
	}
	
	public double calculatePrice(double totalSurface, double price){
		return totalSurface * price;
	}
	

}