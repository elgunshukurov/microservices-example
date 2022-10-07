package az.elgunsh.springsecurityintro.dao;

import lombok.Data;

import java.util.List;

@Data
public class SimpleUser {
    private String username;
    private String password;
    private List<String> roles;
}
