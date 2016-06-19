package ro.sci.electingapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class extends from the {@VotingList} class and optimizez the writing process to the .txt file.
 * @author Andrei Simion
 *
 */
public class OptimizedVotingList extends VotingList implements AutoCloseable {
	private FileWriter writer;

	public void openTXT() throws IOException {
		File file = new File(VOTES);
		writer = new FileWriter(file, true);
	}

	public void closeTXT() throws IOException {
		if (writer != null) {
			writer.close();
		}
	}

	@Override
	public void save(Voter voter) throws IOException {
		writer.append(listFormater.toTXT(voter) + "\n");
	}

	public void close() throws Exception {
		closeTXT();
	}

}
