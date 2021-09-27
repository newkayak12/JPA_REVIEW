package nativeQuery.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "NATIVE_MEMBER")
@Entity
@NamedNativeQuery(
        name = "Member.selectSQL",
        query = "SELECT * FROM NATIVE_MEMBER",
        resultClass = Member_Native.class
)
public class Member_Native {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_NATIVE_ID")
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Hobby_Native> hobby = new ArrayList<>();


}
