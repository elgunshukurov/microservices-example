package az.elgunsh.microserviesrelationsliqubase.dto;

import az.elgunsh.microserviesrelationsliqubase.domain.Community;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component@Data@ToString
public class UserResponseDto {
    private long id;
    private String name;
    private String surname;
    private int age;

    private MailResponseDto mail;
    private List<PhoneResponseDto> phones;
    private List<Community> communities;
}
