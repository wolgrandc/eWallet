package kuehne.nagel.com.est.ewallet.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class TransferForm {
	
	@NotNull
	private String sourceLogin;
	@NotNull
	private String targetLogin;
	@NotNull @DecimalMin("0")
	private BigDecimal value;
	private String label;

	public String getSourceLogin() {
		return sourceLogin;
	}

	public void setSourceLogin(String sourceLogin) {
		this.sourceLogin = sourceLogin;
	}

	public String getTargetLogin() {
		return targetLogin;
	}

	public void setTargetLogin(String targetLogin) {
		this.targetLogin = targetLogin;
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
}
