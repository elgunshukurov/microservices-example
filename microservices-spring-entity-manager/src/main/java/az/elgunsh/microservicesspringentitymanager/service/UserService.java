package az.elgunsh.microservicesspringentitymanager.service;

import az.elgunsh.microservicesspringentitymanager.dto.UserRequestDto;
import az.elgunsh.microservicesspringentitymanager.dto.UserResponseDto;
import az.elgunsh.microservicesspringentitymanager.model.PaginationInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserResponseDto> getUserByCriteria(Map<String, String> map);
    PaginationInfo pageInfo(int page, int perPage);
    UserResponseDto saveUser(UserRequestDto dto);
    UserResponseDto updateUser(long id, UserRequestDto dto);
    long deleteUser(long id);
}
