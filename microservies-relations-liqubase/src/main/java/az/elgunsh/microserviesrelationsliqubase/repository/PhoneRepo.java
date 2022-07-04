package az.elgunsh.microserviesrelationsliqubase.repository;

import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Long>, JpaSpecificationExecutor<Phone> {
    List<Phone> findAllByUserId(long id);

}
