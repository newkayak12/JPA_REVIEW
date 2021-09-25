package jpql.join.inner;

import jpql.group.Group_set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person_innerJoin {
    @Id
    @GeneratedValue
    @Column(name = "PERSON_INNERJOIN_ID")
    private Long id;

    int age;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GROUP_INNERJOIN_ID")
    private Group_innerJoin group;
}
