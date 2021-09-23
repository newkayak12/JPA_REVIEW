package compositeKey.nonIdentifying;

import javax.persistence.*;

@Entity
public class GrandChildNonIden {
    @Id
    @GeneratedValue
    @Column(name = "GRANDCHILD_NONIDEN_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "CHILD_NONIDEN_ID")
    private ChildNonIden childNonIden;

    //복합키를 쓸 일이 없다. 비식별이기 떄문에

}
