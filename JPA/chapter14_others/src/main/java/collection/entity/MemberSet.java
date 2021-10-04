package collection.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "MEMBERSET14")
@Entity
public class MemberSet {
    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "MEMBER_NAME")
    private String username;

    @ManyToOne
    private TeamSet team;

    public MemberSet(String username, TeamSet team) {
        this.username = username;
        this.team = team;
    }
}
