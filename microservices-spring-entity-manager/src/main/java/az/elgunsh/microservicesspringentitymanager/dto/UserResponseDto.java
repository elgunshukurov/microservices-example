package az.elgunsh.microservicesspringentitymanager.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component@Data@ToString
public class UserResponseDto {
    private String name;

    private String surname;

    private int age;
}
