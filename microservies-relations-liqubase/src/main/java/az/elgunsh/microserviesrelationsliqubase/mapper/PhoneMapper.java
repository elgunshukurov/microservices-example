package az.elgunsh.microserviesrelationsliqubase.mapper;

import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import az.elgunsh.microserviesrelationsliqubase.dto.MailRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.MailResponseDto;
import az.elgunsh.microserviesrelationsliqubase.dto.PhoneRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.PhoneResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);;

//    @Mappings(
//            value = {
//                    @Mapping(source = "name", target = "name"),
//                    @Mapping(source = "surname", target = "surname"),
//                    @Mapping(source = "age", target = "age")
//            }
//    )
    Phone toEntity(PhoneRequestDto source);
    List<Phone> toEntity(List<PhoneRequestDto> source);

    PhoneResponseDto toDto(Phone source);

    List<PhoneResponseDto> toDto(List<Phone> employees);

}