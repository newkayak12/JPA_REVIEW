package collection.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "TEAMSET14")
@Entity
public class TeamSet {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("username desc, id asc")
        private Set<MemberSet> members = new HashSet<>();

    public TeamSet(String name) {
        this.name = name;
    }
}
