package mappedSuperClass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "MEMBERMAPPEDSUPERCLASS_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "MEMBERMAPPEDSUPERCLASS_NAME"))
})
public class MemberMappedSuperClass extends BaseEntityMappedSuperClass{
//    id    상속
//    name 상속
    private String email;
}
