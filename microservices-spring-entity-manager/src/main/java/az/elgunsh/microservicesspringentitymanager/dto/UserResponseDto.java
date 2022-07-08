package az.elgunsh.microservicesspringentitymanager.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component@Data@ToString
public class UserResponseDto {
    private long id;
    private String name;
    private String surname;
    private int age;
    private List<ContactResDto> contacts;
}
