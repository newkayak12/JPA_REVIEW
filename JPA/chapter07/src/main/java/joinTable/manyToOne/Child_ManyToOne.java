package joinTable.manyToOne;

import javax.persistence.*;

@Entity
public class Child_ManyToOne {
    @Id
    @GeneratedValue
    @Column(name = "CHILD_MANYTOONE_ID")
    private Long id;
    private String name;

    @ManyToOne(optional = false)
    @JoinTable(name = "PARENT_CHILD_MANYTOONE", joinColumns = @JoinColumn(name = "CHILD_MANYTOONE_ID"), inverseJoinColumns = @JoinColumn(name = "PARENT_MANYTOONE_ID"))
    private Parent_ManyToOne parent_manyToOne;
}
