package kuehne.nagel.com.est.ewallet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kuehne.nagel.com.est.ewallet.service.WalletService;
import kuehne.nagel.com.est.ewallet.to.TransactionTO;
import kuehne.nagel.com.est.ewallet.to.WalletTO;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletService;

	@GetMapping(path = "all")
	public List<WalletTO> listAllWallets() {
		return walletService.listAllWallets();
	}

	@GetMapping("/{login}")
	public ResponseEntity<WalletTO> detailWallet(@PathVariable String login) {
		
		return  Optional
	            .ofNullable( walletService.detailWallet(login) )
	            .map( wallet -> ResponseEntity.ok().body(wallet) )        
	            .orElseGet( () -> ResponseEntity.notFound().build() );
	}
	
	@GetMapping("/statement/{login}")
	public List<TransactionTO> walletStatement(@PathVariable String login){
		return walletService.walletStatement(login);
	}
}
