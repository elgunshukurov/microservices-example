package az.elgunsh.springsecuritying.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.csrf().disable();

        http.authorizeRequests().
                antMatchers("/index/public").
                permitAll().
                antMatchers("/index/private")
                .hasAnyRole("admin","dev").
                antMatchers("/index/post").
                hasAnyRole("creator")
        ;
        super.configure(http);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().
//                withUser("elgun").
//                password(passwordEncoder.encode("1234")).
//                roles("dev").
//                and().
//                withUser("admin").
//                password(passwordEncoder.encode("1234")).
//                roles("admin");
//
//    }
}
