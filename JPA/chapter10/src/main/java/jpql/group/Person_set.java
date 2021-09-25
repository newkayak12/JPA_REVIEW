package jpql.group;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person_set {
    @Id
    @GeneratedValue
    @Column(name = "PERSON_SET_ID")
    private Long id;

    int age;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GROUP_SET_ID")
    private Group_set group;
}
