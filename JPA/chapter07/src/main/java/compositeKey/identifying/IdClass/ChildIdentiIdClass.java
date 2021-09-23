package compositeKey.identifying.IdClass;

import javax.persistence.*;

@Entity
@IdClass(ChildIdentiIdClassId.class)
public class ChildIdentiIdClass {
    @Id
    @ManyToOne
    @JoinColumn(name = "PARENTIDENTIFYING_IDCLASS_ID")
    public ParentIdentiIdClass parentId;

    @Id
    @Column(name = "CHILDIDENTIFYING_IDCLASS_ID")
    private String childId;

    private String name;

}
