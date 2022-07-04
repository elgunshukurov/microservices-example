package az.elgunsh.microserviesrelationsliqubase.service.impl;

import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import az.elgunsh.microserviesrelationsliqubase.domain.User;
import az.elgunsh.microserviesrelationsliqubase.dto.PhoneResponseDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import az.elgunsh.microserviesrelationsliqubase.mapper.MailMapper;
import az.elgunsh.microserviesrelationsliqubase.mapper.PhoneMapper;
import az.elgunsh.microserviesrelationsliqubase.mapper.UserMapper;
import az.elgunsh.microserviesrelationsliqubase.model.PaginationInfo;
import az.elgunsh.microserviesrelationsliqubase.repository.CommunityRepo;
import az.elgunsh.microserviesrelationsliqubase.repository.MailRepo;
import az.elgunsh.microserviesrelationsliqubase.repository.PhoneRepo;
import az.elgunsh.microserviesrelationsliqubase.repository.UserRepo;
import az.elgunsh.microserviesrelationsliqubase.service.PhoneService;
import az.elgunsh.microserviesrelationsliqubase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhoneImpl implements PhoneService {
    private final UserRepo userRepo;
    private final MailRepo mailRepo;
    private final PhoneRepo phoneRepo;
    private final CommunityRepo communityRepo;

    @Override
    public List<PhoneResponseDto> getPhonesById(long id) {
        if (userRepo.existsById(id)){
            return PhoneMapper.INSTANCE.toDto(phoneRepo.findAllByUserId(id));
        }
        throw new IllegalArgumentException();

    }

    @Override
    public List<PhoneResponseDto> createPhones(long id, Phone phone) {
        if (userRepo.existsById(id)){
            userRepo.findById(id).map(
                    user -> {
                        phone.setUser(user);
                        phoneRepo.save(phone);
                        return user;
                    }
            );
            return PhoneMapper.INSTANCE.toDto(phoneRepo.findAllByUserId(id));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<PhoneResponseDto> updatePhones(long id, long phoneId, Phone phone) {
        if (userRepo.existsById(id)){
            if (phoneRepo.findAllByUserId(id).stream().anyMatch(studentPhone -> studentPhone.getId() == phoneId)){
                phoneRepo.findById(id).map(
                        studentPhone -> {
                            studentPhone.setPhone(phone.getPhone());
                            phoneRepo.save(studentPhone);
                            return studentPhone;
                        }
                );
            }

            return PhoneMapper.INSTANCE.toDto(phoneRepo.findAllByUserId(id));
        }
        throw new IllegalArgumentException();
    }
}
