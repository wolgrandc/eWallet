package kuehne.nagel.com.est.ewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kuehne.nagel.com.est.ewallet.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

	Transfer findByCode(String code);

	List<Transfer> findBySourceLogin(String login);

	List<Transfer> findByTargetLogin(String login);

}
