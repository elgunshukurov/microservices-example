package az.elgunsh.microserviesrelationsliqubase.service.impl;

import az.elgunsh.microserviesrelationsliqubase.domain.Community;
import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import az.elgunsh.microserviesrelationsliqubase.domain.User;
import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import az.elgunsh.microserviesrelationsliqubase.mapper.CommunityMapper;
import az.elgunsh.microserviesrelationsliqubase.mapper.MailMapper;
import az.elgunsh.microserviesrelationsliqubase.mapper.PhoneMapper;
import az.elgunsh.microserviesrelationsliqubase.mapper.UserMapper;
import az.elgunsh.microserviesrelationsliqubase.model.PaginationInfo;
import az.elgunsh.microserviesrelationsliqubase.repository.CommunityRepo;
import az.elgunsh.microserviesrelationsliqubase.repository.MailRepo;
import az.elgunsh.microserviesrelationsliqubase.repository.PhoneRepo;
import az.elgunsh.microserviesrelationsliqubase.repository.UserRepo;
import az.elgunsh.microserviesrelationsliqubase.service.UserService;
import graphql.Assert;
import liquibase.hub.model.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.transaction.annotation.Isolation.*;
import static org.springframework.transaction.annotation.Propagation.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = REQUIRED, isolation = READ_UNCOMMITTED)
public class UserImpl implements UserService {
    private final UserRepo userRepo;
    private final MailRepo mailRepo;
    private final PhoneRepo phoneRepo;
    private final CommunityRepo communityRepo;

    @Override
    public List<UserResponseDto> getUserList() {
        return UserMapper.INSTANCE.toDto(userRepo.findAllByJoinFetch());
    }

    @Transactional
    public List<UserResponseDto> getUserByCriteria(Map<String, String> map) {
        Page<User> page = userRepo.findAll(getUserWithSpec(map), makePageable(map));
        return UserMapper.INSTANCE.toDto(page.getContent());

    }

    private PageRequest makePageable(Map<String, String> map){
        int page = 0;
        int size = 20;
        String sortDirection = "asc";
        String sortColumn = "id";
        log.info("{}", map);

        if (map.containsKey("page")){
            page = Integer.parseInt(map.remove("page"));
        }
        if (map.containsKey("size")){
            size = Integer.parseInt(map.remove("size"));
        }
        if (map.containsKey("sortDirection")){
            sortDirection = map.remove("sortDirection");
        }
        if (map.containsKey("sortColumn")){
            sortColumn = map.remove("sortColumn");
        }

        log.info("{} - {} - {} - {}", page, size, sortDirection, sortColumn);


        return PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortColumn);
    }

    private Specification<User> getUserWithSpec(Map<String, String> request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            request.keySet().forEach(key -> {
                if (StringUtils.hasText(key)) {
                    predicates.add(criteriaBuilder.equal(root.get(key), request.get(key)));
                }
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public PaginationInfo pageInfo(int page, int perPage){
        PageRequest pageRequest = PageRequest.of(page,perPage);
        Page<User> pageInfo = userRepo.findAll(pageRequest);
        PaginationInfo paginationInfo = new PaginationInfo();

        paginationInfo.setPage(pageInfo.getNumber());
        paginationInfo.setPerPage(pageInfo.getSize());
        paginationInfo.setTotalPages(pageInfo.getTotalPages());
        paginationInfo.setTotalItems((int) pageInfo.getTotalElements());
        paginationInfo.setHasNextPage(pageInfo.hasNext());
        paginationInfo.setHasPreviousPage(pageInfo.hasPrevious());

        return paginationInfo;
    }

    @Transactional(propagation = REQUIRES_NEW, isolation = READ_COMMITTED)
    @Override
    public UserResponseDto saveUser(UserRequestDto dto) {
        // 1. user-i relation olmadan save edirik
        User user = UserMapper.INSTANCE.toEntity(dto);
        user.setPhones(null);
        user.setMail(null);
        userRepo.save(user);


        // 2. relation olan tereflere artiq id-si olan useri set ve save edirik
        Mail mail = MailMapper.INSTANCE.toEntity(dto.getMail());
        mail.setUser(user);
        mailRepo.save(mail);

        List<Phone> phoneList = PhoneMapper.INSTANCE.toEntity(dto.getPhones());
        phoneList.forEach(phone -> {phone.setUser(user);});
        phoneRepo.saveAll(phoneList);

        communityRepo.saveAll(CommunityMapper.INSTANCE.toEntity(dto.getCommunities()));

        mailRepo.findByUserId(user.getId())
                .ifPresent(
                        user::setMail
                );

        user.setPhones(phoneRepo.findAllByUserId(user.getId()));

        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public UserResponseDto updateUser(long id, UserRequestDto dto) {
        dto.setId(id);

        if (userRepo.existsById(id)) {
            return UserMapper.INSTANCE.toDto(userRepo.save(UserMapper.INSTANCE.toEntity(dto)));
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public long deleteUser(long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
        return id;
    }
}
