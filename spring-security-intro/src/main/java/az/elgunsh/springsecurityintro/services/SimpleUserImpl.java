package az.elgunsh.springsecurityintro.services;

import az.elgunsh.springsecurityintro.repository.AuthRepository;
import az.elgunsh.springsecurityintro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class SimpleUserImpl {
    private final UserRepository userRepository;
    private final AuthRepository roleRepository;



}
