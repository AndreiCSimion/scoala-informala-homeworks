package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class SavingsAccount extends BankAccount {
	private float interest;

	public SavingsAccount(Date accountCreationDate, float monthlyFee, float interest) {
		super(accountCreationDate, monthlyFee);
		this.interest = interest;
	}

	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		float withdrawalCommision = 0;
		super.withdrawFunds(amount + amount * withdrawalCommision);
	}

	@Override
	public float getBalance(Date balanceDate) {
		float balance = super.getBalance(balanceDate);
		return getBalanceWithInterest(balance);
	}

	private float getBalanceWithInterest(float balance) {
		return balance + balance * interest;

	}

}
