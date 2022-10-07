package az.elgunsh.springsecuritying.rest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/public") //no auth
    public String sayHelloPublic() {
        return "Hello World to Everyone!";
    }

    @GetMapping("/user")
    public String sayHello(Authentication authentication) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello , " + authentication.getName() + " !";
    }

    @PostMapping("/post")
    public String createUser() {
        return "User is created!";
    }

    @GetMapping("/developer") //no auth
    public String sayHelloDev(Authentication authentication) {
        List<? extends GrantedAuthority> collect = authentication.getAuthorities()
                .stream().collect(Collectors.toList());
        return "Hello Developer! " + authentication.getName() + " authorities" + collect;
    }

    @GetMapping("/admin") //no auth
    public String sayHelloAdmin(Authentication authentication) {
        List<? extends GrantedAuthority> collect = authentication.getAuthorities()
                .stream().collect(Collectors.toList());
        return "Hello Admin! " + authentication.getName() + " authorities" + collect;
    }

    @GetMapping("/books") //no auth
    public String listBooks(Authentication authentication) {
        List<? extends GrantedAuthority> collect = authentication.getAuthorities()
                .stream().collect(Collectors.toList());
        return "List of some books " + authentication.getName() + " authorities" + collect;
    }

    @PostMapping("/books") //no auth
    public String createBook(Authentication authentication) {
        List<? extends GrantedAuthority> collect = authentication.getAuthorities()
                .stream().collect(Collectors.toList());
        return "Create of some books " + authentication.getName() + " authorities" + collect;
    }
}
