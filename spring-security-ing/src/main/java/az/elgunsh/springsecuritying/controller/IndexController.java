package az.elgunsh.springsecuritying.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/public")
    public String getMessage(){
        return "Welcome to the public zone!";
    }

    @GetMapping("/private")
    public String getPrivateMessage(){
        return "Welcome to the private zone!";
    }

    @PostMapping("/post")
    public String createUser(){
        return "New user is created!";
    }

}
