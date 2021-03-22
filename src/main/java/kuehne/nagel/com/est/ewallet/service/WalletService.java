package kuehne.nagel.com.est.ewallet.service;

import java.util.List;

import kuehne.nagel.com.est.ewallet.to.TransactionTO;
import kuehne.nagel.com.est.ewallet.to.WalletTO;

public interface WalletService {
		
	List<WalletTO> listAllWallets();

	WalletTO detailWallet(String login);

	List<TransactionTO> walletStatement(String login);
	
}
