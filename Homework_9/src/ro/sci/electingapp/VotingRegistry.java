package ro.sci.electingapp;

import java.util.Random;

/**
 * This class hold the vote adding and counting methods.
 * <p>
 * 
 * @author Andrei Simion
 * 
 *
 */
public class VotingRegistry {

	private VotingRepo votingList;

	public VotingRegistry(VotingRepo votingList) {
		this.votingList = votingList;
	}

	public void addVote(Voter voter) throws Exception {
		votingList.vote(voter);
	}

	public void addVoter(VotingList votingList, Voter voter) {
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000 + new Random().nextInt(2000));
					synchronized (votingList) {
						VotingRegistry records = new VotingRegistry(votingList);
						records.addVote(voter);
						System.out.println("New vote:" + voter.toString());
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}.start();
	}

	public void showVotes(VotingList votingList) {
		new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(4000);
						synchronized (votingList) {
							System.out.println("\n----Voting Summary----");
							VotingRegistry registry = new VotingRegistry(votingList);
							System.out.println(votingList.toString());
						}
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}.start();
	}

	public float calculatePercentage(float max, float actual) {
		return actual * 100 / max;
	}
}
