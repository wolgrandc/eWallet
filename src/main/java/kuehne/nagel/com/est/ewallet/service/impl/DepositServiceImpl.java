package kuehne.nagel.com.est.ewallet.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kuehne.nagel.com.est.ewallet.form.DepositForm;
import kuehne.nagel.com.est.ewallet.model.Deposit;
import kuehne.nagel.com.est.ewallet.model.Wallet;
import kuehne.nagel.com.est.ewallet.repository.DepositRepository;
import kuehne.nagel.com.est.ewallet.repository.WalletRepository;
import kuehne.nagel.com.est.ewallet.service.DepositService;
import kuehne.nagel.com.est.ewallet.to.DepositTO;
import kuehne.nagel.com.est.ewallet.util.ServiceUtil;

@Service
public class DepositServiceImpl implements DepositService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	DepositRepository depositRepository;

	@Override
	public DepositTO registerDeposit(DepositForm depositForm) {
		Wallet wallet = walletRepository.findByUserLogin(depositForm.getLogin());
		wallet.setValue(wallet.getValue().add(depositForm.getValue()));
		walletRepository.save(wallet);
		Deposit deposit = new Deposit();
		deposit.setDate(LocalDateTime.now());
		deposit.setTarget(wallet.getUser());
		deposit.setValue(depositForm.getValue());
		deposit.setCode(ServiceUtil.generateCode(deposit.getDate()));
		depositRepository.save(deposit);
		
		return new DepositTO(deposit);
	}

	@Override
	public DepositTO detailDeposit(String code) {
		Deposit deposit = depositRepository.findByCode(code);
		if(deposit == null) {
			return null;
		}
		return new DepositTO(deposit);
	}

}
