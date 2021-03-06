package az.elgunsh.microservicesspringentitymanager.repository.customRepo;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class CustomRepoImpl<T, ID> extends SimpleJpaRepository<T, ID>implements CustomRepository<T, ID> {
    private final EntityManager entityManager;

    public CustomRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void persist(T t) {
        entityManager.persist(t);
    }


    @Transactional
    @Override
    public void merge(T t) {
        entityManager.merge(t);
    }


    @Transactional
    @Override
    public void refresh(T t) {
        entityManager.refresh(t);
    }


    // Parametr olaraq ötürdüyümüz entity-ni L1 cache-dən silir
    @Transactional
    @Override
    public void detach(T t) {
        entityManager.detach(t);
    }


    @Transactional
    @Override
    public void remove(T t) {
        entityManager.remove(t);
    }


    // Entity nin cache de olub olmamasini yoxlayir
    @Transactional
    @Override
    public void contains(T t) {
        entityManager.contains(t);
    }


    // L1 cache-dən bütün entity-ləri silir
    @Transactional
    @Override
    public void clear() {
        entityManager.clear();
    }

    @Transactional
    @Override
    public void flush() {
        entityManager.flush();
    }
}
