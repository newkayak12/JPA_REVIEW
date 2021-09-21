package oneOnOne.mainTable;

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
public class LockerSub {

    @Id
    @GeneratedValue
    @Column(name = "LOCKERSUB_ID")

    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private StudentMain student;
}
