package kuehne.nagel.com.est.ewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kuehne.nagel.com.est.ewallet.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

	Wallet findByUserLogin(String login);

}
