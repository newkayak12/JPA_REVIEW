package joinTable.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent_ManyToMany {
    @Id
    @GeneratedValue
    @Column(name = "PARENT_MANYTOMANY_ID")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "PARENT_CHILD_MANYTOMANY", joinColumns = @JoinColumn(name = "PARENT_MANYTOMANY_ID"), inverseJoinColumns = @JoinColumn(name = "CHILD_MANYTOMANY_ID"))
    private List<Child_ManyToMany> child_manyToManyList = new ArrayList<>();

}
