package ro.sci.electingapp;

/**
 * This is the entry point in the Electing App application. It displays the
 * <p>
 * number of votes and who has the largest number of votes.
 * <p>
 * 
 * @author Andrei Simion
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {

		VotingList votingList = new VotingList();

		VotingRegistry registry = new VotingRegistry(votingList);

		registry.addVoter(votingList, new Voter(1340456756, "Regina", "Paul Blart"));
		registry.addVoter(votingList, new Voter(1340456756, "Maria", "Walt Disney"));
		registry.addVoter(votingList, new Voter(2083385728, "Paul", "Paul Blart"));
		registry.addVoter(votingList, new Voter(2054844395, "George", "Dick"));
		registry.addVoter(votingList, new Voter(1058348683, "Dick", "George"));
		registry.addVoter(votingList, new Voter(1949648586, "Harry", "Paul Blart"));
		registry.addVoter(votingList, new Voter(1094648684, "Baboon", null));
		registry.addVoter(votingList, new Voter(1459684868, "Gorilla", "Britney Spears"));
		registry.addVoter(votingList, new Voter(1349683994, "Ape", "A tree"));
		registry.addVoter(votingList, new Voter(1464575685, "Chimp", "A stick"));

		registry.showVotes(votingList);
	}
}
