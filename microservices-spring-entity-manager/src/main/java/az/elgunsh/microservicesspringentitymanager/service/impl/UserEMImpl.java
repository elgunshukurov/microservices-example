package az.elgunsh.microservicesspringentitymanager.service.impl;

import az.elgunsh.microservicesspringentitymanager.domain.User;
import az.elgunsh.microservicesspringentitymanager.repository.UserRepo;
import az.elgunsh.microservicesspringentitymanager.service.UserEMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserEMImpl implements UserEMService {
    private final UserRepo userRepo;

    @Transactional
    @Override
    public void refresh() {
        log.error("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.error("refresh method starter working (UserRefreshImpl)");
        Optional<User> byId1 = userRepo.findById(1L);
        User user = byId1.get();
        log.info("1) user details which id is 1 -> {}", byId1);

        log.error("\nnext query uploading   ----------------------------------------");

//        userRepo.clear();
//        userRepo.detach(user);
        userRepo.refresh(user);

//        user.setAge(25);
//        userRepo.flush();
//        user.setAge(26);

//        userRepo.remove(user);


        userRepo.findById(1L);
        log.info("2) user details which id is 1 -> {}", user);

        log.error("refresh method ended working (UserRefreshImpl)");
        log.error("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
}
