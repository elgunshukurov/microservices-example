//package az.elgunsh.microservicesspringtransactions.aop;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.engine.spi.SessionImplementor;
//import org.hibernate.internal.SessionImpl;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.sql.SQLException;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class DbAcess {
//
//    SessionImplementor conn;
//    private final WebApplicationContext context;
//
//    public void initCon() {
//        conn = context.getBean(SessionImplementor.class);
//        conn.connection().beginRequest();
//    }
//
//    public void closeCon() {
//        conn.closeConnection();
//    }
//
//    public void beginTransaction() {
//        try {
//            conn.getCon().setAutoCommit(false);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            log.info("Cannot begin transaction: ");
//        }
//    }
//
//    /**
//     * method for commit transaction in manual transaction management invoked from
//     * AOP class after all database update is done
//     */
//    public void commitTransaction() {
//
//        try {
//            conn.getCon().commit();
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            log.info("Cannot commit transaction: " + e.getCause().toString());
//        }
//    }
//
//    /**
//     * method for rollback transaction in manual transaction management invoked from
//     * AOP class if there is any exception while database update is done
//     */
//    public void rollBackTransaction() {
//
//        try {
//            conn.getCon().rollback();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            log.info("Cannot rollback transaction: " + e.getCause().toString());
//        }
//    }
//
//}
