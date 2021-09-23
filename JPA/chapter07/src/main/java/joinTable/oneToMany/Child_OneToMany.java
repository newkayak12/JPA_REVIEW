package joinTable.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Child_OneToMany {
    @Id
    @GeneratedValue
    @Column(name = "CHILD_ONETOMANY_ID")
    private Long id;
    private String name;
}
