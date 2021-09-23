package compositeKey.nonIdentifying;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParentNonIden {
    @Id
    @GeneratedValue
    @Column(name = "PARENT_NONIDEN_ID")
    private Long id;

    private String name;

}
