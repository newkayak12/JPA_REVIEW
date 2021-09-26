package jpql.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString

@Entity(name = "MEMBER_JPQL2")
public class Member_jpql2 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_JPQL2_ID")
    private Long id;

    @OneToMany(mappedBy = "member")
    List<Order_jpql> orders  = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TEAM_JPQL_ID")
    private Team_jpql teamList;


    @Column(name = "MEMBER_JPQL2_NAME")
    private String name;

}
