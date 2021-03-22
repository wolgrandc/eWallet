package kuehne.nagel.com.est.ewallet.service;

import kuehne.nagel.com.est.ewallet.form.WithdrawForm;
import kuehne.nagel.com.est.ewallet.to.WithdrawTO;

public interface WithdrawService {

	WithdrawTO registerWithdraw(WithdrawForm withdrawForm);

	WithdrawTO detailWithdraw(String code);

}
