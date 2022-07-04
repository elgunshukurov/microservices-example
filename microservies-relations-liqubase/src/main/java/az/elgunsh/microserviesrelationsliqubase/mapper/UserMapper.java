package az.elgunsh.microserviesrelationsliqubase.mapper;

import az.elgunsh.microserviesrelationsliqubase.domain.User;
import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);;

//    @Mappings(
//            value = {
//                    @Mapping(source = "name", target = "name"),
//                    @Mapping(source = "surname", target = "surname"),
//                    @Mapping(source = "age", target = "age")
//            }
//    )
    User toEntity(UserRequestDto source);

    UserResponseDto toDto(User source);

    List<UserResponseDto> toDto(List<User> employees);

}