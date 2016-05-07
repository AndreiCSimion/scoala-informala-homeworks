/**
 * This class models a tile that is used to cover an area by pieces.
 * <p>
 * It extends from a {@link AbstractTile}
 * <p>
 * @author Andrei Simion
 */
package jde.workspace;

public class PTile extends AbstractTile {

	public PTile(double price, double length, double width) {
		super(price, length, width);
	}

	public double calculatePrice(double totalSurface, double price) {
		return totalSurface * price;
	}
}