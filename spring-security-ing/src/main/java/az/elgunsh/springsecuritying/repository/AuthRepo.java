package az.elgunsh.springsecuritying.repository;

import az.elgunsh.springsecuritying.dao.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Authority, Long> {
}
