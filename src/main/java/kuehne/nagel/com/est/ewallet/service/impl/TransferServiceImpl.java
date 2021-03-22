package kuehne.nagel.com.est.ewallet.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kuehne.nagel.com.est.ewallet.form.TransferForm;
import kuehne.nagel.com.est.ewallet.model.Transfer;
import kuehne.nagel.com.est.ewallet.model.Wallet;
import kuehne.nagel.com.est.ewallet.repository.TransferRepository;
import kuehne.nagel.com.est.ewallet.repository.WalletRepository;
import kuehne.nagel.com.est.ewallet.service.TransferService;
import kuehne.nagel.com.est.ewallet.to.TransferTO;
import kuehne.nagel.com.est.ewallet.util.ServiceUtil;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	TransferRepository transferRepository;

	@Override
	public TransferTO registerTransfer(TransferForm transferForm) {
		
		validateLimit(transferForm.getSourceLogin(), transferForm.getValue());
		
		Transfer transfer = new Transfer();
		Wallet source = walletRepository.findByUserLogin(transferForm.getSourceLogin());
		source.setValue(source.getValue().subtract(transferForm.getValue()));
		walletRepository.save(source);
		Wallet target = walletRepository.findByUserLogin(transferForm.getTargetLogin());
		target.setValue(target.getValue().add(transferForm.getValue()));
		walletRepository.save(target);
		
		transfer.setTarget(target.getUser());
		transfer.setSource(source.getUser());
		transfer.setLabel(transferForm.getLabel());
		transfer.setValue(transferForm.getValue());
		transfer.setDate(LocalDateTime.now());
		transfer.setCode(ServiceUtil.generateCode(transfer.getDate()));
		
		transferRepository.save(transfer);
		return new TransferTO(transfer);
	}
	
	protected void validateLimit(String login, BigDecimal value) {
		Wallet wallet = walletRepository.findByUserLogin(login);
		if(wallet.getValue().compareTo(value) < 0) {
			throw new RuntimeException("Not enouth money!");
		}
	}

	@Override
	public TransferTO detailTransfer(String code) {
		Transfer transfer = transferRepository.findByCode(code);
		if(transfer == null) {
			return null;
		}
		return new TransferTO(transfer);
	}

}
