package jpql.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor

@Entity
public class Group_set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_SET_ID")
    private Long id;

    private String team;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Person_set> persons = new ArrayList<>();

}
