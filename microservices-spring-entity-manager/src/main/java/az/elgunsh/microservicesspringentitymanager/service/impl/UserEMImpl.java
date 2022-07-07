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

    @Transactional
    @Override
    public void refresh() {
        log.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.error("refresh method starter working (UserRefreshImpl)");
        Optional<User> byId1 = userRepo.findById(1L);

        log.error("next query uploading   ----------------------------------------");

        userRepo.detach(byId1.get());
//        userRepo.refresh(byId1.get());

        userRepo.findById(1L);
        log.error("refresh method ended working (UserRefreshImpl)");
        log.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
