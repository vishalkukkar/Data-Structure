package BankAccounts;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String currency, int units) {
		super(currency, units, AccountTypeEnum.SAVING);
	}

}
