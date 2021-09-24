package nativequery;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@ToString

@Entity(name = "MEMBER_NATIVE")
public class Member_native {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_NATIVE_ID")
    private Long id;

    @Column(name = "MEMBER_NATIVE_NAME")
    private String name;
}
