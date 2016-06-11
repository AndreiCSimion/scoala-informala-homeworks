package ro.sci.tennisgame;

/**
 * This class test that the Array hold the correct amount of tickets.
 * <p>
 * @author Andrei Simion
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class TicketBoothTest {

	@Test
	public void ArraySizeTest() {
		Collection<Double> categIII = new ArrayList<>();
		categIII.add(2.0);
		categIII.add(3.0);
		categIII.remove(2.0);
		assertEquals(1, categIII.size(), 0);

	}

}
