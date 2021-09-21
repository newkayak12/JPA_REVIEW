package oneToMany_oneWay;

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
@Table(name = "TEAMONETOMANY")
public class TeamOneToMany {
    @Id @GeneratedValue
    @Column(name = "TEAMONETOMANY_ID")

    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAMONETOMANY_ID")
    private List<MemberOneToMany> members = new ArrayList<>();

    public TeamOneToMany(String name) {
        this.name = name;
    }
}
