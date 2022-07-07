package az.elgunsh.microservicesspringentitymanager.service.impl;

import az.elgunsh.microservicesspringentitymanager.domain.User;
import az.elgunsh.microservicesspringentitymanager.dto.UserRequestDto;
import az.elgunsh.microservicesspringentitymanager.dto.UserResponseDto;
import az.elgunsh.microservicesspringentitymanager.mapper.UserMapper;
import az.elgunsh.microservicesspringentitymanager.model.PaginationInfo;
import az.elgunsh.microservicesspringentitymanager.repository.UserRepo;
import az.elgunsh.microservicesspringentitymanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepo userRepo;

    public List<UserResponseDto> getUserByCriteria(Map<String, String> map) {
        Page<User> page = userRepo.findAll(getUserWithSpec(map), makePageable(map));
        return UserMapper.INSTANCE.toDto(page.getContent());

    }

    private PageRequest makePageable(Map<String, String> map) {
        int page = 0;
        int size = 20;
        String sortDirection = "asc";
        String sortColumn = "id";
        log.info("{}", map);

        if (map.containsKey("page")) {
            page = Integer.parseInt(map.remove("page"));
        }
        if (map.containsKey("size")) {
            size = Integer.parseInt(map.remove("size"));
        }
        if (map.containsKey("sortDirection")) {
            sortDirection = map.remove("sortDirection");
        }
        if (map.containsKey("sortColumn")) {
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

    public PaginationInfo pageInfo(int page, int perPage) {
        PageRequest pageRequest = PageRequest.of(page, perPage);
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

    @Override
    public UserResponseDto saveUser(UserRequestDto dto){
        User user = userRepo.save(UserMapper.INSTANCE.toEntity(dto));
        return UserMapper.INSTANCE.toDto(user);
    }

    @Transactional(noRollbackFor = RuntimeException.class)
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
