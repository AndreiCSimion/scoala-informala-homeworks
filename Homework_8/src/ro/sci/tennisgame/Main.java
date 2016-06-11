package ro.sci.tennisgame;

/**
 * This is the main class that prints out the messages for exceptions and prices of tickets sold.
 * <p>
 * @author Andrei Simion
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws CategoryTicketsSoldOutException, SoldOutException {
		TicketBooth T1 = new TicketBooth();
		HashMap<Integer, Collection<Double>> totalTickets = new HashMap<>();
		Collection<Double> I = new ArrayList<>(6);
		I.add(1.0);
		I.add(2.0);
		I.add(3.0);
		I.add(4.0);
		I.add(5.0);
		I.add(6.0);
		Collection<Double> II = new ArrayList<>(9);
		II.add(1.0);
		II.add(2.0);
		II.add(3.0);
		II.add(4.0);
		II.add(5.0);
		II.add(6.0);
		II.add(7.0);
		II.add(8.0);
		II.add(9.0);
		Collection<Double> III = new ArrayList<>(15);
		III.add(1.0);
		III.add(2.0);
		III.add(3.0);
		III.add(4.0);
		III.add(5.0);
		III.add(6.0);
		III.add(7.0);
		III.add(8.0);
		III.add(9.0);
		III.add(10.0);
		III.add(11.0);
		III.add(12.0);
		III.add(13.0);
		III.add(14.0);
		III.add(15.0);

		totalTickets.put(3, III);
		totalTickets.put(2, II);
		totalTickets.put(1, I);
		T1.sellTicket(4);
		T1.priceOfTicketsSold();
		System.out.println(totalTickets.toString());
	}

}
