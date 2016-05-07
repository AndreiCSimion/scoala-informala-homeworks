/**
 * This abstract class defines a Tile in general (rectangular, triangular etc)
 * <p>
 * It implements the area calculation methods
 * <p>
 * @author Andrei Simion
 */

package jde.workspace;

public abstract class AbstractTile implements Tile{
	private double length;
	private double width;
	private double price;
	private double hypo;
	
	/**
	 * Constructor invoked by the rectangular tiles
	 * @param length
	 * @param width
	 * @param price
	 */
	public AbstractTile(double length, double width, double price){
		this.length = length;
		this.width = width;
		this.price = price;
	}
	/**
	 * Constructor invoked by the triangular tile
	 * @param hypo
	 * @param price
	 */
	public AbstractTile(double hypo, double price){
		this.hypo = hypo;
	}
	
	public double getHypo(){
		return hypo;
	}
			
	public double getLength(){
		return length;
	}

	public double getWidth(){
		return width;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double calculateArea(){
		return this.getLength() * this.getWidth();
		}
	
	public double calculatePTArea(){
		return Math.pow(hypo, 2) / 2;
	}
	
}