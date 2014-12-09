package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
