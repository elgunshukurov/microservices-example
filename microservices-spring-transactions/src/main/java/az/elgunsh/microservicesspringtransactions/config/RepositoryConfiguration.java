//package az.elgunsh.microservicesspringtransactions.config;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jndi.JndiObjectFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"az.elgunsh.microservicesspringtransactions.repository",
//        "az.elgunsh.microservicesspringtransactions.service"})
//@EntityScan(basePackages = "az.elgunsh.microservicesspringtransactions.domain")
//@EnableJpaRepositories(basePackages = "az.elgunsh.microservicesspringtransactions.repository", entityManagerFactoryRef = "entityManagerFactory")
//@EnableTransactionManagement
//public class RepositoryConfiguration {
//
//    @Bean
//    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
//        // Here you can create your datasource using application.properties configuration or inject the datasource from the server application.
//        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//        bean.setJndiName("JNDI_IN_YOUR_SERVER");
//        bean.setProxyInterface(DataSource.class);
//        bean.setLookupOnStartup(true);
//        bean.afterPropertiesSet();
//        return (DataSource) bean.getObject();
//    }
//
//}