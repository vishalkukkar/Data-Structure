package BankAccounts;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String currency, int units) {
		super(currency, units, AccountTypeEnum.SAVING);
	}

}
