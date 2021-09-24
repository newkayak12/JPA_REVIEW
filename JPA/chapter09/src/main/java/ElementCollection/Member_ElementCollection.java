package ElementCollection;

import embedded.embeddedPlus.Address_embeddedplus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter

@Entity
public class Member_ElementCollection {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ELEMENTCOLLECTION_ID")
    private Long id;

    @Embedded
    private Address_ElementCollection homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ELEMENTCOLLECTION_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS_ELEMENTCOLLECTION", joinColumns = @JoinColumn(name = "MEMBER_ELEMENTCOLLECTION_ID"))
    private List<Address_ElementCollection> addressHistory = new ArrayList<>();
//   값 타입 컬렉션 대신 엔티티로 받는 것이 더 쉬울 수 있다.
    /*
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "MEMBER_ELEMENTCOLLECTION_ID")
        private List<Address_ElementCollection> addressHistory = new ArrayList<>();



     */
}
