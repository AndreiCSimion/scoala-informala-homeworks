package ro.sci.electingapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class VotingRegistryTest {

	@Test
	public void test() {
		Collection<Voter> votes = new ArrayList<>();
		votes.add(new Voter(1578290283, "Alabala", "Nobody"));
		votes.add(new Voter(1578290283, "Portocala", "Someone"));
		votes.remove(new Voter(1578290283, "Portocala", "Someone"));
		assertEquals(2, votes.size(), 0);

	}

}
