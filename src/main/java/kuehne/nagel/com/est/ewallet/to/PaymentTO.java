package kuehne.nagel.com.est.ewallet.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import kuehne.nagel.com.est.ewallet.model.Payment;

public class PaymentTO {

	private UserTO user;
	private LocalDateTime date;
	private BigDecimal value;
	private String label;
	private String code;
	
	public PaymentTO() {
		super();
	}
	
	public PaymentTO(Payment payment) {
		super();
		this.user = new UserTO(payment.getSource());
		this.date = payment.getDate();
		this.label = payment.getLabel();
		this.value = payment.getValue();
		this.code = payment.getCode();
	}

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

}
