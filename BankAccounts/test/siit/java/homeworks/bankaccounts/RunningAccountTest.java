/**
 * This class is a test class for the {@link RunningAccount} class.
 * <p>
 * @author Andrei Simion
 */
package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class RunningAccountTest {

	@Test
	public void whenMultipleOperationsCalled_balanceIsCorrect() throws InsufficientFundsException {
		// given
		float monthlyFee = 5;
		Date accountCreationDate = TestUtils.getDate(2016, 1, 1);
		float credit = 2000;
		RunningAccount runningAccount = new RunningAccount(accountCreationDate, monthlyFee, credit);

		// when
		runningAccount.withdrawFunds(100);
		runningAccount.withdrawFunds(200);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		float actualBalance = runningAccount.getBalance(balanceInterogationTime);

		// then
		float withdrawalsAndAdds = credit - 200 - 100;
		float expectedBalanceAfterOperations = credit - withdrawalsAndAdds;

		assertEquals("4 months worth of withdrawals and adds have been deducted.", 700,
				actualBalance, 0);
	}

}
