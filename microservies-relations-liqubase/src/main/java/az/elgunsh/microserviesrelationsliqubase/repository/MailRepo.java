package az.elgunsh.microserviesrelationsliqubase.repository;

import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailRepo extends JpaRepository<Mail, Long>, JpaSpecificationExecutor<Mail> {

    Optional<Mail> findByUserId(Long aLong);

}
