package kuehne.nagel.com.est.ewallet.enums;

public enum TransactionTypeEnum {
	
	TRANSFER_TARGET(1, "Transfer Received"),
	DEPOSIT(2, "Deposit"),
	TRANSFER_SOURCE(3, "Transfer Made"),
	PAYMENT(4, "Payment"),
	WHITDRAW(5, "Whitdraw");
	
	private int code;
	private String name;
	
	private TransactionTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
