package az.elgunsh.springsecurityintro;

import az.elgunsh.springsecurityintro.dao.Authority;
import az.elgunsh.springsecurityintro.dao.User;
import az.elgunsh.springsecurityintro.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityIntroApplication {
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityIntroApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService service) {
        return args -> {
            service.save(Authority.builder().authority("ROLE_ADMIN").build());
            service.save(Authority.builder().authority("ROLE_USER").build());

            service.save(User.builder()
                    .username("ali")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .password(passwordEncoder.encode("1234"))
                    .authorities(new ArrayList<>())
                    .build());
            service.addRoleTo("ali","ROLE_USER");

            service.save(User.builder()
                    .username("mammad")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .password(passwordEncoder.encode("1234"))
                    .authorities(new ArrayList<>())
                    .build());
            service.addRoleTo("mammad","ROLE_ADMIN");

//            service.save(Authority.builder().authority("ROLE_USER").build());
            service.save(User.builder()
                    .username("tural")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .password(passwordEncoder.encode("1234"))
                    .authorities(new ArrayList<>())
                    .build());
            service.addRoleTo("tural","ROLE_USER");
            service.addRoleTo("tural","ROLE_ADMIN");
        };
    }

}
