package az.elgunsh.microservicesspringentitymanager.repository.customRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T, ID> extends JpaRepository<T,ID> {
    void persist(T t);
    void merge(T t);
    void refresh(T t);
    void detach(T t);
    void remove(T t);
    void contains(T t);
    void clear();
    void flush();
}
