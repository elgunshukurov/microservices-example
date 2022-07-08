package az.elgunsh.microservicesspringentitymanager.mapper;

import az.elgunsh.microservicesspringentitymanager.domain.Contact;
import az.elgunsh.microservicesspringentitymanager.dto.ContactReqDto;
import az.elgunsh.microservicesspringentitymanager.dto.ContactResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);;

    Contact toEntity(ContactReqDto source);
    List<Contact> toEntity(List<ContactReqDto> source);

    ContactResDto toDto(Contact source);

    List<ContactResDto> toDto(List<Contact> source);

}