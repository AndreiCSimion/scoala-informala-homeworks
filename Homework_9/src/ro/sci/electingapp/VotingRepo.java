package ro.sci.electingapp;

import java.util.List;

public interface VotingRepo {

	void save(Voter voter) throws Exception;

	List<Voter> loadAll() throws Exception;
}
