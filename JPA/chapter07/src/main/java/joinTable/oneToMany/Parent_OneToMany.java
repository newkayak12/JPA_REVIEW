package joinTable.oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent_OneToMany {
    @Id
    @GeneratedValue
    @Column(name = "PARENT_ONETOMANY_ID")
    private Long id;
    String name;

    @OneToMany
    @JoinTable(name = "PARENT_CHILD_ONETOMANY", joinColumns = @JoinColumn(name = "PARENT_ONETOMANY_ID"), inverseJoinColumns = @JoinColumn(name = "CHILD_ONETOMANY_ID"))
    private List<Child_OneToMany> child_oneToManyList = new ArrayList<>();


}
