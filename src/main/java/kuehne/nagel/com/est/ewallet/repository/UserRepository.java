package kuehne.nagel.com.est.ewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kuehne.nagel.com.est.ewallet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);

}
