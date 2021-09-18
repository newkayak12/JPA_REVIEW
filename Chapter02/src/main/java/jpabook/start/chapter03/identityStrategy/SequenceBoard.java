package jpabook.start.chapter03.identityStrategy;

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
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ",
        initialValue = 1, allocationSize = 1
)
/*
    name : 식별자 생성기 이름
    sequenceName : 데이터베이스에 등록되어 있는 시퀀스 이름
    initValue : 시작
    allocationSize : 시퀀스 한 번 호출에 증가하는 수 (성능 최적화????)
//    미리 50까지 돌려 놓고 JPA에서 메모리에 가져다 놓고 그냥 배치하는 방식임 ( 굳이 시퀀스를 찾고 테이블에 넣는 두 번의 쿼리를 줄일 수 있음 그러나! 아무래도 직접 핸들링 하는 경우 부담스럽다는 단점이 있음
    catalog, schema
*/

public class SequenceBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
//    트랜잭션 지연 지원 안 함
    private Long id;

    @Column
    private String data;
}
