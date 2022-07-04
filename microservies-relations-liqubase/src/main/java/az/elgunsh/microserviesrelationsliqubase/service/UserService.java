package az.elgunsh.microserviesrelationsliqubase.service;

import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import az.elgunsh.microserviesrelationsliqubase.model.PaginationInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserResponseDto> getUserList();
    List<UserResponseDto> getUserByCriteria(Map<String, String> map);
    PaginationInfo pageInfo(int page, int perPage);
    UserResponseDto saveUser(UserRequestDto dto);
    UserResponseDto updateUser(long id, UserRequestDto dto);
    long deleteUser(long id);
}
