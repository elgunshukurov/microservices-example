package az.elgunsh.microservicesspringentitymanager.repository.customRepo;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class CustomRepoImpl<T, ID>
        extends SimpleJpaRepository<T, ID>
        implements CustomRepository<T, ID>
{

    private final EntityManager entityManager;

    public CustomRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void refresh(T t) {
        entityManager.refresh(t);
    }

    @Transactional
    @Override
    public void detach(T t) {
        entityManager.detach(t);
    }
    @Transactional
    @Override
    public void flush() {
        entityManager.flush();
    }
}
