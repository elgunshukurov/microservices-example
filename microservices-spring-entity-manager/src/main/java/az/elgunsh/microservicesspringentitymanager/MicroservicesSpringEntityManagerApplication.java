package az.elgunsh.microservicesspringentitymanager;

import az.elgunsh.microservicesspringentitymanager.repository.customRepo.CustomRepoImpl;
import az.elgunsh.microservicesspringentitymanager.service.impl.UserEMImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories(repositoryBaseClass = CustomRepoImpl.class)
public class MicroservicesSpringEntityManagerApplication implements CommandLineRunner {
    private final UserEMImpl userRefresh;

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesSpringEntityManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRefresh.refresh();
    }

}
