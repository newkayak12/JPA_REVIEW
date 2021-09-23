package joinTable.oneToOne;

import javax.persistence.*;

@Entity
public class Child_OneToOne {
    @Id
    @GeneratedValue
    @Column(name = "CHILD_ONETOONE_ID")
    private Long id;

    private String name;


    //양방향 매핑
    @OneToOne(mappedBy = "child_oneToOne")
    private Parent_OneToOne parent_oneToOne;
}
