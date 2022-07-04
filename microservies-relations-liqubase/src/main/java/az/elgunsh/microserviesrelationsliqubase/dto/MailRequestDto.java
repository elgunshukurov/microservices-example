package az.elgunsh.microserviesrelationsliqubase.dto;

import az.elgunsh.microserviesrelationsliqubase.domain.Community;
import az.elgunsh.microserviesrelationsliqubase.domain.Mail;
import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
@ToString
public class MailRequestDto {
    private long id;
    private String email;
}
