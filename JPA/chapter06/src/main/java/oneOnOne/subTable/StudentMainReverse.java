package oneOnOne.subTable;

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
@Table(name = "STUDENT_REVERSE")
public class StudentMainReverse {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_REVERSE_ID")
    private Long id;

    private String userName;

    @OneToOne(mappedBy = "studentReverse")
    private LockerSubReverse lockerReverse;
}
