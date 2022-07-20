package az.elgunsh.springsecuritying.repository;

import az.elgunsh.springsecuritying.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
