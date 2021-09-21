package oneToMany_oneWay;

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
@Table(name = "MEMEBERONETOMANY")
public class MemberOneToMany {

    @Id @GeneratedValue
    @Column(name = "MEMBERONETOMANY_ID")

    private Long id;

    private String userName;

    public MemberOneToMany(String userName) {
        this.userName = userName;
    }
}
