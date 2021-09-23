package compositeKey.identifying.IdClass;

import javax.persistence.*;

@Entity
@IdClass(GrandChildIdentiIdClassId.class)
public class GrandChildIdentiIdClass {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENTIDENTIFYING_IDCLASS_ID"),
            @JoinColumn(name = "CHILDIDENTIFYING_IDCLASS_ID")
    })
    private ChildIdentiIdClass childIdentiIdClass;

    @Id
    @Column(name = "GRANDCHILDIDENTIFYING_IDCLASS_ID")
    private String grandChildid;
    private String name;

}
