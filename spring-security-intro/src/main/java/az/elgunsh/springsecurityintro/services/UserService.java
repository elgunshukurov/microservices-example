package az.elgunsh.springsecurityintro.services;


import az.elgunsh.springsecurityintro.dao.Authority;
import az.elgunsh.springsecurityintro.dao.User;

import java.util.List;

public interface UserService {
    User save(User user);
    Authority save(Authority role);
    void addRoleTo(String username, String roleName);
    User get(String username);
    List<User> list();
}
