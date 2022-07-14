package az.elgunsh.springsecurity.repository;

import az.elgunsh.springsecurity.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByName(String name);
}
