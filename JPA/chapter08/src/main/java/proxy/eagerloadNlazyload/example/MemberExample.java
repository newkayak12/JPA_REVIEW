package proxy.eagerloadNlazyload.example;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
//@ToString
@Entity
public class MemberExample {
    @Id
    @Column(name = "MEMBER_EXAMPLE_ID")
    private String id;

    private String username;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_EXAMPLE_ID")
    private TeamExample team;

    @OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
    List<OrderExample> orders = new ArrayList<>();

    public MemberExample(String id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public void addTeam(TeamExample team){
        if(team!= null){
            team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }

}
