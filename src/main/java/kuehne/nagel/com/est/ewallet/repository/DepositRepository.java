package kuehne.nagel.com.est.ewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kuehne.nagel.com.est.ewallet.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

	Deposit findByCode(String code);

	List<Deposit> findByTargetLogin(String login);

}
