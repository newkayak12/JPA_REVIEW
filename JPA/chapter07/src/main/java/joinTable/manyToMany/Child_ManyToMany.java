package joinTable.manyToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Child_ManyToMany {
    @Id
    @GeneratedValue
    @Column(name = "CHILD_MANYTOMANY_ID")
    private Long id;
    private String name;
}
