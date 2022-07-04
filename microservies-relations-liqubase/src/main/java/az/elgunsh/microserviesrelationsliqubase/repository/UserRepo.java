package az.elgunsh.microserviesrelationsliqubase.repository;

import az.elgunsh.microserviesrelationsliqubase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select u from User u " +
            "left join fetch u.mail as m ")
    List<User> findAllByJoinFetch();

//    @Query("select u from User u " +
//            "left join fetch u.mail as m " +
//            "left join fetch u.phones as p " +
//            "left join fetch  u.communities as c")
//    List<User> findAllByJoinFetch();

}
