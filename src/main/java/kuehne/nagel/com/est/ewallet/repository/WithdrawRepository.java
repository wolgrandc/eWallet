package kuehne.nagel.com.est.ewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kuehne.nagel.com.est.ewallet.model.Withdraw;

public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {

	Withdraw findByCode(String code);

	List<Withdraw> findBySourceLogin(String login);

}
