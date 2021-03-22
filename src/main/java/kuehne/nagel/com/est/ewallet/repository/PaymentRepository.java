package kuehne.nagel.com.est.ewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kuehne.nagel.com.est.ewallet.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Payment findByCode(String code);

	List<Payment> findBySourceLogin(String login);

}
