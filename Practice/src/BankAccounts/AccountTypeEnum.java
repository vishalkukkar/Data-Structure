package BankAccounts;

public enum AccountTypeEnum {

	CHECKING(0, 1L, "CHECKING"),
	SAVING(1, 2L, "SAVING"),
	BROKERAGE(2, 3L, "BROKERAGE");
	
	private Integer index;
	private Long criteriaId;
	private String desc;
	
	private AccountTypeEnum(Integer index, Long criteriaId, String desc) {
		this.index = index;
		this.criteriaId = criteriaId;
		this.desc = desc;
	}

	public int getIndex() {
		return index;
	}

	public Long getCriteriaId() {
		return criteriaId;
	}
	
	public Object getName() {
		return desc;
	}
}
