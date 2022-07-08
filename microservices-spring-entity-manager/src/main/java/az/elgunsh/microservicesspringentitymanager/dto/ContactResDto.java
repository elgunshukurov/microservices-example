package az.elgunsh.microservicesspringentitymanager.dto;

import az.elgunsh.microservicesspringentitymanager.domain.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class ContactResDto {
    private long id;
    private String type;
    private String value;
}
