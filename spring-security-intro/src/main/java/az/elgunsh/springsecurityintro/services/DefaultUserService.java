package az.elgunsh.springsecurityintro.services;


import az.elgunsh.springsecurityintro.dao.Authority;
import az.elgunsh.springsecurityintro.dao.User;
import az.elgunsh.springsecurityintro.repository.AuthRepository;
import az.elgunsh.springsecurityintro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class DefaultUserService implements UserService{
    private final UserRepository userRepository;
    private final AuthRepository roleRepository;
//    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public Authority save(Authority role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleTo(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Authority role = roleRepository.findByAuthority(roleName);
        user.getAuthorities().add(role);
//        userRepository.save(user);
    }

    @Override
    public User get(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    // artiq spring menim yazdigim metoda gore authenticate edecek
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found!");
//        }
//        List<SimpleGrantedAuthority> authorities = user.getAuthorities().stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
//    }
}
