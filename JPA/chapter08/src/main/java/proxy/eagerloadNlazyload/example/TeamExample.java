package proxy.eagerloadNlazyload.example;

import lombok.*;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TeamExample {
    @Id
    @Column(name = "TEAM_EXAMPLE_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
    List<MemberExample> members = new ArrayList<>();
}
