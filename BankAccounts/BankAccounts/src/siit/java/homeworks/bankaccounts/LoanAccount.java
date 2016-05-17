package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class LoanAccount extends BankAccount {
	private float interest;
	private float installment;

	public LoanAccount(Date accountCreationDate, float monthlyFee, float interest, float installment) {
		super(accountCreationDate, 0);
		this.interest = interest;
		this.installment = installment;
	}

	@Deprecated
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getBalance(Date balanceDate) {
		float balance = super.getBalance(balanceDate);
		return getBalanceWithInterest(balance);
	}

	private float getBalanceWithInterest(float balance) {
		return balance + balance * interest;

	}
public boolean equals (Date balanceDate, Object deadline, float installment){
	if (balanceDate==deadline)
		return true;
	if 	(!(balanceDate instanceof deadine){
		return false;
		
	}
	
}
	//public float getBalance(Date balanceDate, float installment) {
		//Object deadline = null;
		//if (balanceDate < deadline)
			
			
			
			//throw new UnsupportedOperationException();
		//else if (balance < 0) {
			//return getBalanceWithInstallmentWithdrawn(balance, balanceDate);
		//}
	//}

	private float getBalanceWithInstallmentWithdrawn(float balance, Date balanceDate) {
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(accountCreationDate);
		int accountCreationMonth = accountCreationTime.get(Calendar.MONTH);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int currentMonth = balanceTime.get(Calendar.MONTH);
		return balance - installment * (currentMonth - accountCreationMonth);
	}

}
