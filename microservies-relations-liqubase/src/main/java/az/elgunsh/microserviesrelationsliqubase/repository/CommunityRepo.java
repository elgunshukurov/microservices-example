package az.elgunsh.microserviesrelationsliqubase.repository;

import az.elgunsh.microserviesrelationsliqubase.domain.Community;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepo extends JpaRepository<Community, Long>, JpaSpecificationExecutor<Community> {
}
