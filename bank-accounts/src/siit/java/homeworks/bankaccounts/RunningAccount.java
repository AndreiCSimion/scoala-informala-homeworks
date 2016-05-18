/**
 * This class models a basic {@link BankAccount} that is used to store salaries.
 * <p>
 * @author Andrei Simion
 */
package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class RunningAccount extends BankAccount {
	private float credit;

	public RunningAccount(Date accountCreationDate, float monthlyFee, float credit) {
		super(accountCreationDate, monthlyFee);
		this.credit = credit;
	}

}
