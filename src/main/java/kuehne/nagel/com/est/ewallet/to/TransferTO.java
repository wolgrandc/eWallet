package kuehne.nagel.com.est.ewallet.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import kuehne.nagel.com.est.ewallet.model.Transfer;

public class TransferTO {

	private UserTO source;
	private UserTO target;
	private BigDecimal value;
	private LocalDateTime date;
	private String code;

	public TransferTO() {
		super();
	}
	
	public TransferTO(Transfer transfer) {
		super();
		this.source = new UserTO(transfer.getSource());
		this.target = new UserTO(transfer.getTarget());
		this.date = transfer.getDate();
		this.value = transfer.getValue();
		this.code = transfer.getCode();
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

}
