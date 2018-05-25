package BankAccounts;

public class BrokerageAccount extends BankAccount {

	public BrokerageAccount(String currency, int units) {
		super(currency, units, AccountTypeEnum.SAVING);
	}

}
