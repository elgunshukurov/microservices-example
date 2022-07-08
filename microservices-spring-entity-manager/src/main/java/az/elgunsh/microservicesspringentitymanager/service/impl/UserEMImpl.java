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
//    private final RefreshRepository refreshRepository;

//    @Transactional
    @Override
    public void refresh() {
        log.error("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.error("refresh method starter working (UserRefreshImpl)");
        Optional<User> byId1 = userRepo.findById(1L);
        log.info("1) user details which id is 1 -> {}", byId1);

        log.error("\nnext query uploading   ----------------------------------------");

//        userRepo.clear();
//        userRepo.detach(byId1.get());
//        userRepo.refresh(byId1.get());

        userRepo.findById(1L);
        log.info("2) user details which id is 1 -> {}", byId1);

        log.error("refresh method ended working (UserRefreshImpl)");
        log.error("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
}
