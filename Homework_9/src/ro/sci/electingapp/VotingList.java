package ro.sci.electingapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class saves the votes to a .txt file and reads from it.
 * 
 * @author Andrei Simion
 *
 */
public class VotingList implements VotingRepo {

	protected static final String VOTES = "votes.txt";
	protected VotingListFormater listFormater = new VotingListFormater();

	@Override
	public synchronized void vote(Voter voter) throws IOException {
		File file = new File(VOTES);
		try (FileWriter writer = new FileWriter(file, true)) {
			writer.append(listFormater.toTXT(voter) + "\n");
		}
	}

	@Override
	public synchronized List<Voter> showAllVotes() throws FileNotFoundException, IOException {
		File file = new File(VOTES);
		ArrayList<Voter> votes = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while (line != null) {
				Voter v = listFormater.fromTXT(line);
				votes.add(v);
				line = reader.readLine();
			}
		}
		return votes;
	}

	@Override
	public String toString() {
		return "VotingList [listFormater=" + listFormater + "]";
	}

}
