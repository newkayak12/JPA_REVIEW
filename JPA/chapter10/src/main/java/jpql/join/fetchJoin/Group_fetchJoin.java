package jpql.join.fetchJoin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class Group_fetchJoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_FETCHJOIN_ID")
    private Long id;

    private String team;

    @OneToMany(mappedBy = "group")
    private List<Person_fetchJoin> persons = new ArrayList<>();

}
