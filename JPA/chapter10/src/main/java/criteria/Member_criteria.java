package criteria;

import lombok.*;

import javax.persistence.*;

//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Builder

@Entity(name = "MEMBER_CRITERIA")
public class Member_criteria {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_CRITERIA_ID")
    private Long id;

    @Column(name = "MEMBER_CRITERIA_NAME")
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_CRITERIA_ID")
    private  Team_criteria team;
}
