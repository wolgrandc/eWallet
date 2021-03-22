package kuehne.nagel.com.est.ewallet.service;

import kuehne.nagel.com.est.ewallet.form.TransferForm;
import kuehne.nagel.com.est.ewallet.to.TransferTO;

public interface TransferService {
	
	TransferTO registerTransfer(TransferForm transferForm);

	TransferTO detailTransfer(String code);

}
