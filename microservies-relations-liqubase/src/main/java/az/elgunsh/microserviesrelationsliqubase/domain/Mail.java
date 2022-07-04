package az.elgunsh.microserviesrelationsliqubase.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Mail implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String email;

    @OneToOne()
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
