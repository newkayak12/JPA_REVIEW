package OneOnOne.mainTable;

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
public class StudentMain {
    @Id
    @GeneratedValue
    @Column(name = "STUDENTMAIN_ID")
    private Long id;

    private String userName;

    @OneToOne
    @JoinColumn(name = "LOCKERSUB_ID")
    private LockerSub locker;

}
