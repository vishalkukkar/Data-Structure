package BankAccounts;

public class BankAccount {

	private String currency;
	private int units;
	private AccountTypeEnum accountType;


	public BankAccount(String currency, int units,AccountTypeEnum accountType) {

		this.currency = currency;
		this.units = units;
		this.accountType = accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getAmount() {
		return units;
	}

	public void setAmount(Integer amount) {
		this.units = amount;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}

}