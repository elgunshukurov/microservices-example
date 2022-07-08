package az.elgunsh.microservicesspringentitymanager.repository;

import az.elgunsh.microservicesspringentitymanager.domain.User;
import az.elgunsh.microservicesspringentitymanager.repository.customRepo.CustomRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;


public interface UserRepo
        extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User>,
        CustomRepository<User,Long>
{
    @EntityGraph(value = "user_contacts_graph", type = EntityGraph.EntityGraphType.FETCH)
    @Override
    Optional<User> findById(Long aLong);

    //    entity graphla birge isletmek
//    @EntityGraph(value = "graphName", type = EntityGraph.EntityGraphType.FETCH)
//    List<User> collectWithContacts();



//    join fetch numunesi
//    @Query("select u from User u " +
//            "left join fetch u.mail as m ")
//    List<User> findAllByJoinFetch();

}
