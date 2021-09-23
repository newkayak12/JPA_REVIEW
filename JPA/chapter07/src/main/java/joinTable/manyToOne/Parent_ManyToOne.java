package joinTable.manyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent_ManyToOne {
    @Id
    @GeneratedValue
    @Column(name = "PARENT_MANYTOONE_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent_manyToOne")
    private List<Child_ManyToOne> child_manyToOneList = new ArrayList<>();

}
