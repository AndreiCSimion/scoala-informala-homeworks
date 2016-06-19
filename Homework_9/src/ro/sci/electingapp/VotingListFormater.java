package ro.sci.electingapp;
/**
 * This class formats the lines in the .txt file.
 * @author Andrei Simion
 *
 */
public class VotingListFormater {

	public String toTXT(Voter voter) {
		return ("[" + voter.getName() + "," + voter.getCNP() + "," + voter.getCandidateName() + "]");
	}

	public Voter fromTXT(String txtLine) {
		String[] tokens = txtLine.split(",");
		Long a = Long.parseLong(tokens[0]);
		String b = String.valueOf(tokens[1]);
		String c = String.valueOf(tokens[2]);
		return new Voter(a, b, c);
	}

}
