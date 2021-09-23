package compositeKey.nonIdentifying;

import javax.persistence.*;

@Entity
public class ChildNonIden {
    @Id
    @GeneratedValue
    @Column(name = "CHILD_NONIDEN_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_NONIDEN_ID")
    private  ParentNonIden parentNonIden;
}
