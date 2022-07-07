package az.elgunsh.microserviesrelationsliqubase;

import az.elgunsh.microserviesrelationsliqubase.repository.CustomRepoImpl;
import az.elgunsh.microserviesrelationsliqubase.service.impl.UserRefreshImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories(repositoryBaseClass = CustomRepoImpl.class)
public class MicroserviesRelationsLiqubaseApplication implements CommandLineRunner {
    private final UserRefreshImpl userRefresh;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviesRelationsLiqubaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRefresh.refresh();
    }
}
