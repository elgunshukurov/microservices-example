package az.elgunsh.microservicesspringentitymanager.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ToString
public class UserRequestDto {
    private long id;
    private String name;
    private String surname;
    private int age;
    private List<ContactReqDto> contacts;
}
