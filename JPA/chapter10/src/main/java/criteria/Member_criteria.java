package criteria;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@ToString

@Entity(name = "MEMBER_CRITERIA")
public class Member_criteria {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_CRITERIA_ID")
    private Long id;

    @Column(name = "MEMBER_CRITERIA_NAME")
    private String name;
}
