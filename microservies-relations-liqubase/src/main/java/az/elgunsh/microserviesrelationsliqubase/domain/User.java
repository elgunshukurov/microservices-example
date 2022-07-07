package az.elgunsh.microserviesrelationsliqubase.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.*;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(fetch = FetchType.LAZY)
    private String name;
    private String surname;
    private int age;

    @OneToOne(cascade = CascadeType.REFRESH, mappedBy = "user")
    private Mail mail;

    @OneToMany(cascade=CascadeType.REFRESH, mappedBy = "user", fetch = LAZY)
    private List<Phone> phones;

    @ManyToMany(cascade=CascadeType.REFRESH, fetch = LAZY)
    private List<Community> communities;
}
