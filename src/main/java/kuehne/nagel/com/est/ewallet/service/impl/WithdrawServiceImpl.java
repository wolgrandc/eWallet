package kuehne.nagel.com.est.ewallet.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kuehne.nagel.com.est.ewallet.form.WithdrawForm;
import kuehne.nagel.com.est.ewallet.model.Wallet;
import kuehne.nagel.com.est.ewallet.model.Withdraw;
import kuehne.nagel.com.est.ewallet.repository.WalletRepository;
import kuehne.nagel.com.est.ewallet.repository.WithdrawRepository;
import kuehne.nagel.com.est.ewallet.service.WithdrawService;
import kuehne.nagel.com.est.ewallet.to.WithdrawTO;
import kuehne.nagel.com.est.ewallet.util.ServiceUtil;

@Service
public class WithdrawServiceImpl implements WithdrawService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	WithdrawRepository withdrawRepository;

	@Override
	public WithdrawTO registerWithdraw(WithdrawForm withdrawForm) {
		
		validateLimit(withdrawForm.getLogin(), withdrawForm.getValue());
		
		Wallet wallet = walletRepository.findByUserLogin(withdrawForm.getLogin());
		wallet.setValue(wallet.getValue().subtract(withdrawForm.getValue()));
		walletRepository.save(wallet);
		
		Withdraw withdraw = new Withdraw();
		withdraw.setDate(LocalDateTime.now());
		withdraw.setSource(wallet.getUser());
		withdraw.setValue(withdrawForm.getValue());
		withdraw.setCode(ServiceUtil.generateCode(withdraw.getDate()));
		withdrawRepository.save(withdraw);
		
		return new WithdrawTO(withdraw);
	}
	
	protected void validateLimit(String login, BigDecimal value) {
		Wallet wallet = walletRepository.findByUserLogin(login);
		if(wallet.getValue().compareTo(value) < 0) {
			throw new RuntimeException("Not enouth money!");
		}
	}

	@Override
	public WithdrawTO detailWithdraw(String code) {
		Withdraw withdraw = withdrawRepository.findByCode(code);
		if(withdraw == null) {
			return null;
		}
		return new WithdrawTO(withdraw);
	}

}
