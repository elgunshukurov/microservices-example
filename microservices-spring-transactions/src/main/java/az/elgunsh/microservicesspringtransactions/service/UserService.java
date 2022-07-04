package az.elgunsh.microservicesspringtransactions.service;

import az.elgunsh.microservicesspringtransactions.dto.UserRequestDto;
import az.elgunsh.microservicesspringtransactions.dto.UserResponseDto;
import az.elgunsh.microservicesspringtransactions.exception.UserException;
import az.elgunsh.microservicesspringtransactions.model.PaginationInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserResponseDto> getUserByCriteria(Map<String, String> map);
    PaginationInfo pageInfo(int page, int perPage);
    UserResponseDto saveUser(UserRequestDto dto) throws UserException;
    UserResponseDto updateUser(long id, UserRequestDto dto);
    long deleteUser(long id);
}
