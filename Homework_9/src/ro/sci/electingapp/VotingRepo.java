package ro.sci.electingapp;

import java.util.List;

public interface VotingRepo {

	void vote(Voter voter) throws Exception;

	List<Voter> showAllVotes() throws Exception;
}
