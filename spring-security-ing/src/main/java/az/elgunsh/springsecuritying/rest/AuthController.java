package az.elgunsh.springsecuritying.rest;
import az.elgunsh.springsecuritying.common.jwt.JwtService;
import az.elgunsh.springsecuritying.repository.UserRepo;
import az.elgunsh.springsecuritying.rest.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private static final Duration ONE_DAY = Duration.ofDays(1);
    private static final Duration ONE_WEEK = Duration.ofDays(7);

    private final JwtService jwtService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepo userRepository;

    @PostMapping("/sign-in")
    public AccessTokenDto authorize(@RequestBody LoginDto loginDto) {
        log.trace("Login request by user {}", loginDto.getUsername());

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.issueToken(authentication);
        log.info("Authentication is {}", authentication);
        return new AccessTokenDto(token);
    }


}

