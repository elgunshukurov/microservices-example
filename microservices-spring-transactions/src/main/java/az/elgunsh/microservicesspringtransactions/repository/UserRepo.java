package az.elgunsh.microservicesspringtransactions.repository;

import az.elgunsh.microservicesspringtransactions.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
