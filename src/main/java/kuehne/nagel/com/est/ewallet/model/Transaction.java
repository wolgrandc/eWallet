package kuehne.nagel.com.est.ewallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Transaction {
	
	@ManyToOne
	private User source;
	@ManyToOne
	private User target;
	private BigDecimal value;
	private LocalDateTime date;
	private String code;

	public User getSource() {
		return source;
	}

	public void setSource(User source) {
		this.source = source;
	}

	public User getTarget() {
		return target;
	}

	public void setTarget(User target) {
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
