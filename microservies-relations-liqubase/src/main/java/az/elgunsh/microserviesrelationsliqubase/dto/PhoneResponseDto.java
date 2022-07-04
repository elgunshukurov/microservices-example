package az.elgunsh.microserviesrelationsliqubase.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component@Data@ToString
public class PhoneResponseDto {
    private long id;
    private String phone;
}
