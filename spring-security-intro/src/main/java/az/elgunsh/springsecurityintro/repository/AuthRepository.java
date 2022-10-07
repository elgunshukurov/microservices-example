package az.elgunsh.springsecurityintro.repository;

import az.elgunsh.springsecurityintro.dao.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
