package az.elgunsh.microservicesspringtransactions.aop;

import az.elgunsh.microservicesspringtransactions.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Component
@Slf4j
@Aspect
@AllArgsConstructor
public class TransactionalAdvice {
    private final PlatformTransactionManager ptm;

    @Pointcut(value = "@annotation(az.elgunsh.microservicesspringtransactions.aop.CTransactional)")
    private void logTransactionalAnnotation() {
    }


    @Around(value = "logTransactionalAnnotation()")
    public Object logExecutionTime(ProceedingJoinPoint point) throws Throwable {
        TransactionStatus transaction = ptm.getTransaction(TransactionDefinition.withDefaults());
        Object proceed;
        try {
            proceed = point.proceed();
            ptm.commit(transaction);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage());
            ptm.rollback(transaction);
            throw new RuntimeException("Just RuntimeException was happened!");
        } catch (UserException ex) {
            log.error(ex.getMessage());
            ptm.commit(transaction);
            throw new UserException("Just UserException was happened!");
        }
        return proceed;

    }

//    @Before(value = "logTransactionalAnnotation()")
//    public void beforeMethodExecution(JoinPoint point){
//        ptm.getTransaction(TransactionDefinition.withDefaults());
//        log.info("Before method execution");
//    }
//
//    @AfterReturning(value = "logTransactionalAnnotation()")
//    public void afterMethodReturning(JoinPoint point) throws SQLException {
//        log.info("After method returning");
//        ptm.commit(ptm.getTransaction(TransactionDefinition.withDefaults()));
//    }
//
//    @AfterThrowing(value = "logTransactionalAnnotation()", throwing = "error")
//    public void afterMethodThrowing(JoinPoint point, Throwable error) throws SQLException {
//        log.info("After method returning");
//        if (error instanceof RuntimeException) {
//            log.info("line 69");
//            ptm.rollback(ptm.getTransaction(TransactionDefinition.withDefaults()));
//        } else {
//            log.info("line 72");
//            ptm.commit(ptm.getTransaction(TransactionDefinition.withDefaults()));
//        }
//    }

}
