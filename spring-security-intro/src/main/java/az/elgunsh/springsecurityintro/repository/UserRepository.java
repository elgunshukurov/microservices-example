package az.elgunsh.springsecurityintro.repository;

import az.elgunsh.springsecurityintro.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
