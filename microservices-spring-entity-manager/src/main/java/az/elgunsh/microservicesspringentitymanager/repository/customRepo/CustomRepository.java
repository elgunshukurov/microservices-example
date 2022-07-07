package az.elgunsh.microservicesspringentitymanager.repository.customRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T, ID> extends JpaRepository<T,ID> {
    void refresh(T t);
    void detach(T t);
    void flush();
}
