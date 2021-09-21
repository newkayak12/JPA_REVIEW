package OneOnOne.subTable;

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
@Table(name = "LOCKER_REVERSE")
public class LockerSubReverse {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_REVERSE_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "STUDENT_REVERSE_ID")
    private StudentMainReverse studentReverse;

}
