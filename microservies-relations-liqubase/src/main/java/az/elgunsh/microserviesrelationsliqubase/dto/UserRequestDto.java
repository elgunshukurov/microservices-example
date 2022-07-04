package az.elgunsh.microserviesrelationsliqubase.dto;

import az.elgunsh.microserviesrelationsliqubase.domain.Community;
import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Component
@Data
@ToString
public class UserRequestDto {
    private long id;
    private String name;
    private String surname;
    private int age;

    private MailRequestDto mail;
    private List<PhoneRequestDto> phones;
    private List<Community> communities;
}
