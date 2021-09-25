package jpql.join.fetchJoin;

import lombok.*;

import javax.persistence.*;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person_fetchJoin {
    @Id
    @GeneratedValue
    @Column(name = "PERSON_FETCHJOIN_ID")
    private Long id;

    int age;

    @ManyToOne    @JoinColumn(name = "GROUP_FETCHJOIN_ID")

    private Group_fetchJoin group;

    public void addGroup(Group_fetchJoin group){
        if(group!= null){
            group.getPersons().remove(this);
        }
        this.group = group;
        group.getPersons().add(this);
    }
}
