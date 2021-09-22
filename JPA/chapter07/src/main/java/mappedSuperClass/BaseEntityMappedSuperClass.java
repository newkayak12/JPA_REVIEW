package mappedSuperClass;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntityMappedSuperClass {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
