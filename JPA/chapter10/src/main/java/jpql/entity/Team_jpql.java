package jpql.entity;

import jpql.Member_jpql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team_jpql {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_JPQL_ID")
    private Long id;
    private String name;

}
