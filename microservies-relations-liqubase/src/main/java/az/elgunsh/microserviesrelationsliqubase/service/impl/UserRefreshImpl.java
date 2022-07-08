package az.elgunsh.microserviesrelationsliqubase.service.impl;

import az.elgunsh.microserviesrelationsliqubase.domain.User;
import az.elgunsh.microserviesrelationsliqubase.repository.*;
import az.elgunsh.microserviesrelationsliqubase.service.UserRefreshService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRefreshImpl implements UserRefreshService {
    private final UserRepo userRepo;
    private final RefreshRepository refreshRepository;

    @Transactional
    @Override
    public void refresh() {
        log.error("refresh method starter working (UserRefreshImpl)");
        Optional<User> byId1 = userRepo.findById(1L);

        log.error("next query uploading");

        refreshRepository.refresh(byId1.get());

        userRepo.findById(1L);
        log.error("refresh method ended working (UserRefreshImpl)");
    }
}
