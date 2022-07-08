package az.elgunsh.microservicesspringentitymanager.repository;

import az.elgunsh.microservicesspringentitymanager.domain.Contact;
import az.elgunsh.microservicesspringentitymanager.domain.User;
import az.elgunsh.microservicesspringentitymanager.repository.customRepo.CustomRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


public interface ContactRepo
        extends JpaRepository<Contact, Long>,
        JpaSpecificationExecutor<Contact>,
        CustomRepository<Contact,Long>
{
//    @EntityGraph(value = "user_contacts_graph", type = EntityGraph.EntityGraphType.FETCH)
//    @Override
//    Optional<Contact> findById(Long aLong);


}
