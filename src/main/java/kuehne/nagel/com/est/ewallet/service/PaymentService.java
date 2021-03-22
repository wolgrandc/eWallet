package kuehne.nagel.com.est.ewallet.service;

import kuehne.nagel.com.est.ewallet.form.PaymentForm;
import kuehne.nagel.com.est.ewallet.to.PaymentTO;

public interface PaymentService {
	
	PaymentTO registerPayment(PaymentForm paymentForm);

	PaymentTO detailPayment(String code);

}
