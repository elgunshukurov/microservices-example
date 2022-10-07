package az.elgunsh.springsecurityintro.services;


import az.elgunsh.springsecurityintro.dao.Authority;
import az.elgunsh.springsecurityintro.dao.User;

import java.util.List;

public interface SimpleUserService {
    User get(String username);
    List<User> list();
}
