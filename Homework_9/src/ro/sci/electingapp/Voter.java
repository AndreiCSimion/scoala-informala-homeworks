package ro.sci.electingapp;

/**
 * This class models a basic Voter. It has fields such as CNP, name and who is
 * <p>
 * his candidate option.
 * 
 * @author Andrei Simion
 *
 */
public class Voter {
	private long CNP;
	private String voterName;
	private String candidateName;

	public Voter(long CNP, String voterName, String candidateName) {
		this.CNP = CNP;
		this.voterName = voterName;
		this.candidateName = candidateName;
	}

	public String getName() {
		return voterName;
	}

	public long getCNP() {
		return CNP;
	}

	public String getCandidateName() {
		return candidateName;
	}

	@Override
	public String toString() {
		return "Voter [name=" + voterName + ", CNP=" + CNP + ", candidateName=" + candidateName + "]";
	}

}
