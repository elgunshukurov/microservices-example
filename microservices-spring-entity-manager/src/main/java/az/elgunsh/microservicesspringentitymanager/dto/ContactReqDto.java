package az.elgunsh.microservicesspringentitymanager.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class ContactReqDto {
    private long id;
    private String type;
    private String value;
}
