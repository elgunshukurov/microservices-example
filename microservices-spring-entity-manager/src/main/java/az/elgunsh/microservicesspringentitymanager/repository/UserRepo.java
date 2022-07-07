package az.elgunsh.microservicesspringentitymanager.repository;

import az.elgunsh.microservicesspringentitymanager.domain.User;
import az.elgunsh.microservicesspringentitymanager.repository.customRepo.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepo
        extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User>,
        CustomRepository<User,Long>
{

//    @Query("select u from User u " +
//            "left join fetch u.mail as m ")
//    List<User> findAllByJoinFetch();

//    @Query("select u from User u " +
//            "left join fetch u.mail as m " +
//            "left join fetch u.phones as p " +
//            "left join fetch  u.communities as c")
//    List<User> findAllByJoinFetch();

}
