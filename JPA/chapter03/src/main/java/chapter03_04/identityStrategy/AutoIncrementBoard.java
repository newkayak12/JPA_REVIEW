package chapter03_04.identityStrategy;

import lombok.*;

import javax.persistence.*;
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "board")
public class AutoIncrementBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    트랜잭션 지연 지원 안 함
    private Long id;

    @Column
    private String data;


}
