package kuehne.nagel.com.est.ewallet.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class DepositForm {
	@NotNull
	private String login;
	@NotNull @DecimalMin("0")
	private BigDecimal value;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
