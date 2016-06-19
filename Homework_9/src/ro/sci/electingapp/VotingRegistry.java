package ro.sci.electingapp;

/**
 * This class hold the vote adding and counting methods.
 * <p>
 * @author Andrei Simion
 * 
 *
 */
public class VotingRegistry {

	private VotingRepo votingList;

	public VotingRegistry(VotingRepo votingList) {
		this.votingList = votingList;
	}

	public void addVoter(Voter voter) throws Exception {
		votingList.save(voter);
	}

	public float calculatePercentage(float max, float actual) {
		return actual * 100 / max;
	}
}
