package kuehne.nagel.com.est.ewallet.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import kuehne.nagel.com.est.ewallet.model.Withdraw;

public class WithdrawTO {
	
	private UserTO user;
	private BigDecimal value;
	private LocalDateTime date;
	private String code;
		
	public WithdrawTO() {
		super();
	}

	public WithdrawTO(Withdraw withdraw) {
		super();
		this.user = new UserTO(withdraw.getSource());
		this.value = withdraw.getValue();
		this.date = withdraw.getDate();
		this.code = withdraw.getCode();
	}

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
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
