/**
 * This class is a test class for the {@link SavingsAccount} class.
 * <p>
 * @author Andrei Simion
 */
package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class SavingsAccountTest {

	@Test
	public void whenInterestIsReceived_BalanceIsCorrect() throws InsufficientFundsException {
		// given
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 8, 5);
		// when
		savingsAccount.addFunds(584);
		savingsAccount.addFunds(584);
		savingsAccount.addFunds(584);
		Date balanceInterogationTime = TestUtils.getDate(2016, 8, 1);
		// then
		assertEquals("7 months worth of interest.", 10176, savingsAccount.getBalance(balanceInterogationTime), 0);

	}
}
