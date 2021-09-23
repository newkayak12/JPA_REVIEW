package compositeKey.identifying.IdClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParentIdentiIdClass {
    @Id
    @Column(name = "PARENTIDENTIFYING_IDCLASS_ID")
    private String id;

    private String name;
}
