package primitive;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member_primitive {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private  int age;
}
