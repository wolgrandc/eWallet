package kuehne.nagel.com.est.ewallet.to;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kuehne.nagel.com.est.ewallet.model.Wallet;

public class WalletTO {
	
	private UserTO user;
	private BigDecimal value;
	
	public WalletTO() {
		super();
	}
	
	public WalletTO(Wallet wallet) {
		super();
		this.user = new UserTO(wallet.getUser());
		this.value = wallet.getValue();
	}
	
	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public static List<WalletTO> toWalletTO(List<Wallet> walletList) {
		List<WalletTO> wallets = walletList.stream().map(wallet -> (new WalletTO(wallet))).collect(Collectors.toList());
		return wallets;
	}
	
}
