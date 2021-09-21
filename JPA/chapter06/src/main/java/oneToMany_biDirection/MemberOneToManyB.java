package oneToMany_biDirection;

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
@Table(name = "MEMEBERONETOMANYB")
public class MemberOneToManyB {

    @Id @GeneratedValue
    @Column(name = "MEMBERONETOMANYB_ID")

    private Long id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "TEAMONETOMANYB_ID",insertable = false, updatable = false)
    private TeamOneToManyB team;
//    그냥 다 : 일 매핑이 낫다.

    public MemberOneToManyB(String userName) {
        this.userName = userName;
    }
}
