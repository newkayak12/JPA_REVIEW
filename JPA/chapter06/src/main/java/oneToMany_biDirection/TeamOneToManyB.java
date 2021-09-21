package oneToMany_biDirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TEAMONETOMANYB")
public class TeamOneToManyB {
    @Id @GeneratedValue
    @Column(name = "TEAMONETOMANYB_ID")

    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAMONETOMANYB_ID")
    private List<MemberOneToManyB> members = new ArrayList<>();

    public TeamOneToManyB(String name) {
        this.name = name;
    }
}
