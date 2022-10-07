package az.elgunsh.springsecuritying;

import az.elgunsh.springsecuritying.dao.Authority;
import az.elgunsh.springsecuritying.dao.User;
import az.elgunsh.springsecuritying.repository.AuthRepo;
import az.elgunsh.springsecuritying.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringSecurityIngApplication implements CommandLineRunner {

	private final PasswordEncoder passwordEncoder;
	private final UserRepo userRepository;
	private final AuthRepo authorityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityIngApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1L);
		user.setUsername("orxan");
		user.setPassword(passwordEncoder.encode("1234"));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setEnabled(true);
		user.setCredentialsNonExpired(true);

		Authority authority = new Authority();
		authority.setId(1L);
		authority.setAuthority("ROLE_ceo");

		Authority authority1 = new Authority();
		authority1.setId(2L);
		authority1.setAuthority("ROLE_admin");
		user.setAuthorities(List.of(authority1, authority));
		 authorityRepository.save(authority);
		 authorityRepository.save(authority1);
		 userRepository.save(user);
	}
}

