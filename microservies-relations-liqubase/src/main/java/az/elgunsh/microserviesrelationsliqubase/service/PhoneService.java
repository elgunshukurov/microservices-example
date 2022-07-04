package az.elgunsh.microserviesrelationsliqubase.service;

import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import az.elgunsh.microserviesrelationsliqubase.dto.PhoneResponseDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import az.elgunsh.microserviesrelationsliqubase.model.PaginationInfo;

import java.util.List;
import java.util.Map;

public interface PhoneService {
    List<PhoneResponseDto> getPhonesById(long id);
    List<PhoneResponseDto> createPhones(long id, Phone phone);
    List<PhoneResponseDto> updatePhones(long id, long phoneId, Phone phone);
}
