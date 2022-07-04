package az.elgunsh.microservicesspringtransactions.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class UserRequestDto {
    private long id;

    private String name;

    private String surname;

    private int age;
}
