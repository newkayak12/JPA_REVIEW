package jpql.entityDirectUsage.namedQuery;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
//XML혹은 어노테이션
@NamedQuery(
        name = "Friend.findByFriendName",
        query = "SELECT f FROM Friend_namedQuery f WHERE f.name = :FriendName"
)
public class Friend_namedQuery {
    @Id
    @GeneratedValue
    @Column(name = "FRIEND_NAMEDQUERY_ID")
    private Long id;

    private String name;
    private String birthDay;
    private String phoneNumber;
}
