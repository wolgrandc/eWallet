package kuehne.nagel.com.est.ewallet.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kuehne.nagel.com.est.ewallet.form.PaymentForm;
import kuehne.nagel.com.est.ewallet.model.Payment;
import kuehne.nagel.com.est.ewallet.model.Wallet;
import kuehne.nagel.com.est.ewallet.repository.PaymentRepository;
import kuehne.nagel.com.est.ewallet.repository.WalletRepository;
import kuehne.nagel.com.est.ewallet.service.PaymentService;
import kuehne.nagel.com.est.ewallet.to.PaymentTO;
import kuehne.nagel.com.est.ewallet.util.ServiceUtil;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public PaymentTO registerPayment(PaymentForm paymentForm) {
		validateLimit(paymentForm.getLogin(), paymentForm.getValue());
		Wallet wallet = walletRepository.findByUserLogin(paymentForm.getLogin());
		wallet.setValue(wallet.getValue().subtract(paymentForm.getValue()));
		walletRepository.save(wallet);
		Payment payment = new Payment();
		payment.setDate(LocalDateTime.now());
		payment.setLabel(paymentForm.getLabel());
		payment.setSource(wallet.getUser());
		payment.setValue(paymentForm.getValue());
		payment.setCode(ServiceUtil.generateCode(payment.getDate()));
		paymentRepository.save(payment);
		return new PaymentTO(payment);
	}
	
	protected void validateLimit(String login, BigDecimal value) {
		Wallet wallet = walletRepository.findByUserLogin(login);
		if(wallet.getValue().compareTo(value) < 0) {
			throw new RuntimeException("Not enouth money!");
		}
	}

	@Override
	public PaymentTO detailPayment(String code) {
		Payment payment = paymentRepository.findByCode(code);
		if(payment == null) {
			return null;
		}
		return new PaymentTO(payment);
	}

}
