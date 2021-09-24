package jpql;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Setter
@ToString

@Entity(name = "MEMBER_JPQL")
public class Member_jpql {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_JPQL_ID")
    private Long id;

    @Column(name = "MEMBER_JPQL_NAME")
    private String name;
}
