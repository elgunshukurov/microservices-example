package az.elgunsh.microservicesspringtransactions.mapper;

import az.elgunsh.microservicesspringtransactions.domain.User;
import az.elgunsh.microservicesspringtransactions.dto.UserRequestDto;
import az.elgunsh.microservicesspringtransactions.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);;

    User toEntity(UserRequestDto source);

    UserResponseDto toDto(User source);

    List<UserResponseDto> toDto(List<User> employees);

}