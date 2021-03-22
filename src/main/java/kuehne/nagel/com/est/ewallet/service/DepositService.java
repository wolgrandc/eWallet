package kuehne.nagel.com.est.ewallet.service;

import kuehne.nagel.com.est.ewallet.form.DepositForm;
import kuehne.nagel.com.est.ewallet.to.DepositTO;

public interface DepositService {

	DepositTO registerDeposit(DepositForm deposit);

	DepositTO detailDeposit(String code);
	
}
