package ro.sci.tennisgame;

/**
 * This class models a Ticket Booth that contains tickets in several collections(HashMap, ArrayList).
 * <p>
 * It also contains a method for selling tickets and a method for calculating the price of the tickets sold.
 * <p>
 * @author Andrei Simion
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TicketBooth {

	private int noOfTickets = 30;

	HashMap<Integer, Collection<Double>> totalTickets = new HashMap<>();
	Collection<Double> categI = new ArrayList<>();
	Collection<Double> categII = new ArrayList<>();
	Collection<Double> categIII = new ArrayList<>();

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void sellTicket(int noOfTickets) throws CategoryTicketsSoldOutException, SoldOutException {
		for (Iterator<Double> iterator = categIII.iterator(); iterator.hasNext();) {
			Double Double = iterator.next();
			if (Double == null)
				iterator.remove();
			System.out.println("[" + "Category III" + "Price: 50" + categIII + "]");

			if (categIII == null)
				throw new CategoryTicketsSoldOutException();

		}
		System.out.println("No more Category III tickets available!");

		for (Iterator<Double> iterator = categII.iterator(); iterator.hasNext();) {
			Double Double = iterator.next();
			if (Double == null)
				iterator.remove();
			System.out.println("[" + "Category II" + "Price: 80" + categII + "]");

			if (categII == null)
				throw new CategoryTicketsSoldOutException();

		}
		System.out.println("No more Category II tickets available!");

		for (Iterator<Double> iterator = categI.iterator(); iterator.hasNext();) {
			Double Double = iterator.next();
			if (Double == null)
				iterator.remove();
			System.out.println("[" + "Category I" + "Price: 120" + categI + "]");
		}
		if (totalTickets == null)
			throw new SoldOutException();
		System.out.println("No more tickets available!");
	}

	public void priceOfTicketsSold() {
		double catIIIPrice = categIII.size() * 50;
		double catIIPrice = categII.size() * 80;
		double catIPrice = categI.size() * 120;
		System.out.println("The prices per category of tickets sold are:" + "[CatI]:" + catIPrice + "," + "[CatII]:"
				+ catIIPrice + "," + "[CatIII]:" + catIIIPrice);
		double totalTicketsPrice = catIIIPrice + catIIPrice + catIPrice;
		System.out.println("The total price of tickets sold is:" + totalTicketsPrice);
		return;

	}

	@Override
	public String toString() {
		return "TicketBooth [totalTickets=" + totalTickets + ", categI=" + categI + ", categII=" + categII
				+ ", categIII=" + categIII + "]";
	}

}
