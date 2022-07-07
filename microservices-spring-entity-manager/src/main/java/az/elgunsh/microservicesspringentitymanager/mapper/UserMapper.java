package az.elgunsh.microservicesspringentitymanager.mapper;

import az.elgunsh.microservicesspringentitymanager.domain.User;
import az.elgunsh.microservicesspringentitymanager.dto.UserRequestDto;
import az.elgunsh.microservicesspringentitymanager.dto.UserResponseDto;
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