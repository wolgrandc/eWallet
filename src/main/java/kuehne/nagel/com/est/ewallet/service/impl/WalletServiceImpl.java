package kuehne.nagel.com.est.ewallet.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kuehne.nagel.com.est.ewallet.enums.TransactionTypeEnum;
import kuehne.nagel.com.est.ewallet.model.Deposit;
import kuehne.nagel.com.est.ewallet.model.Payment;
import kuehne.nagel.com.est.ewallet.model.Transfer;
import kuehne.nagel.com.est.ewallet.model.Wallet;
import kuehne.nagel.com.est.ewallet.model.Withdraw;
import kuehne.nagel.com.est.ewallet.repository.DepositRepository;
import kuehne.nagel.com.est.ewallet.repository.PaymentRepository;
import kuehne.nagel.com.est.ewallet.repository.TransferRepository;
import kuehne.nagel.com.est.ewallet.repository.WalletRepository;
import kuehne.nagel.com.est.ewallet.repository.WithdrawRepository;
import kuehne.nagel.com.est.ewallet.service.WalletService;
import kuehne.nagel.com.est.ewallet.to.TransactionTO;
import kuehne.nagel.com.est.ewallet.to.WalletTO;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	TransferRepository transferRepository;
	
	@Autowired
	WithdrawRepository withdrawRepository;
	
	@Autowired
	DepositRepository depositRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public List<WalletTO> listAllWallets() {
		
		List<Wallet> walletList = walletRepository.findAll(); 

		return WalletTO.toWalletTO(walletList);
		
	}

	@Override
	public WalletTO detailWallet(String login) {
		
		Wallet wallet = walletRepository.findByUserLogin(login);
		
		if(wallet == null) {
			return null;
		}
		
		return new WalletTO(wallet);
	}

	@Override
	public List<TransactionTO> walletStatement(String login) {
		
		List<TransactionTO> transactions = new ArrayList<TransactionTO>();
		
		List<Transfer> transferencesSource = transferRepository.findBySourceLogin(login);
		List<Transfer> transferencesTarget = transferRepository.findByTargetLogin(login);
		List<Withdraw> withdraws = withdrawRepository.findBySourceLogin(login);
		List<Deposit> deposits = depositRepository.findByTargetLogin(login);
		List<Payment> payments = paymentRepository.findBySourceLogin(login);
		
		transactions.addAll(TransactionTO.toTransaction(transferencesSource, TransactionTypeEnum.TRANSFER_SOURCE));
		transactions.addAll(TransactionTO.toTransaction(transferencesTarget, TransactionTypeEnum.TRANSFER_TARGET));
		transactions.addAll(TransactionTO.toTransaction(withdraws, TransactionTypeEnum.WHITDRAW));
		transactions.addAll(TransactionTO.toTransaction(deposits, TransactionTypeEnum.DEPOSIT));
		transactions.addAll(TransactionTO.toTransaction(payments, TransactionTypeEnum.PAYMENT));
		
		transactions.sort(Comparator.comparing(TransactionTO::getDate));
		
		return transactions;
	}
	
}
