package az.elgunsh.microserviesrelationsliqubase.mapper;

import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.User;
import az.elgunsh.microserviesrelationsliqubase.dto.MailRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.MailResponseDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MailMapper {

    MailMapper INSTANCE = Mappers.getMapper(MailMapper.class);;

//    @Mappings(
//            value = {
//                    @Mapping(source = "name", target = "name"),
//                    @Mapping(source = "surname", target = "surname"),
//                    @Mapping(source = "age", target = "age")
//            }
//    )
    Mail toEntity(MailRequestDto source);

    MailResponseDto toDto(Mail source);

    List<MailResponseDto> toDto(List<Mail> employees);

}