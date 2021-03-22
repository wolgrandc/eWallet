package kuehne.nagel.com.est.ewallet.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import kuehne.nagel.com.est.ewallet.enums.TransactionTypeEnum;
import kuehne.nagel.com.est.ewallet.model.Transaction;

public class TransactionTO {

	private UserTO source;
	private UserTO target;
	private BigDecimal value;
	private String date;
	private String type;
	private boolean direction;
	private String code;

	public TransactionTO() {
		super();
	}

	public TransactionTO(UserTO source, UserTO target, BigDecimal value, LocalDateTime date, String code, TransactionTypeEnum type,
			boolean direction) {
		super();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		
		this.source = source;
		this.target = target;
		this.value = value;
		this.date = formatter.format(date);
		this.type = type.getName();
		this.code = code;
		this.direction = direction;
	}

	public UserTO getSource() {
		return source;
	}

	public void setSource(UserTO source) {
		this.source = source;
	}

	public UserTO getTarget() {
		return target;
	}

	public void setTarget(UserTO target) {
		this.target = target;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	

	public static List<TransactionTO> toTransaction(List<? extends Transaction> transactions, TransactionTypeEnum transactionType) {
		
		boolean direction = (transactionType.getCode() < 3) ? true: false;
		
		
		List<TransactionTO> transactionsTO = transactions.stream().map(transaction -> 
				new TransactionTO(
					transaction.getSource() == null ? null : new UserTO(transaction.getSource()),  
					transaction.getTarget() == null ? null : new UserTO(transaction.getTarget()), 
					transaction.getValue(), transaction.getDate(), 
					transaction.getCode(), transactionType,  direction))
				.collect(Collectors.toList());
		
		return transactionsTO;
	}


}
