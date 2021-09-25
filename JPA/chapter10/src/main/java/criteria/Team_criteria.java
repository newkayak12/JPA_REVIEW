package criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team_criteria {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_CRITERIA_ID")
    private Long id;

    private String name;

}
