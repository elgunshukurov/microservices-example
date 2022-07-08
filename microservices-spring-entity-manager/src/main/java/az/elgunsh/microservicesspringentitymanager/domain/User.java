package az.elgunsh.microservicesspringentitymanager.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NamedEntityGraphs(
        {
                @NamedEntityGraph(
                        name = "user_contacts_graph",
                        attributeNodes = {
                                @NamedAttributeNode("contacts")
                        }
                )
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private int age;

    @OneToMany(mappedBy = "user",
//            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY)
    private List<Contact> contacts;
}
