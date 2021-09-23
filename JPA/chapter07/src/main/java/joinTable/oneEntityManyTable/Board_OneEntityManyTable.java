package joinTable.oneEntityManyTable;

import javax.persistence.*;

@Entity
@Table(name = "BOARD_ONEENTITYMANYTABLE")
@SecondaryTable(name = "BOARD_DETAIL_ONEENTITYMANYTABLE", pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ONEENTITYMANYTABLE_ID"))
/*
    Table을 이용해서 board 테이블을 연결했다.

    @SecondaryTable을 이용해서 하나의 테이블 추가적으로 연결했다.
        - name : 매핑할 다른 테이블의 이름
        - pkJoinColumns : 매핑할 다른 테이블의 기본 키 컬럼 속성
 */
public class Board_OneEntityManyTable {
    @Id
    @GeneratedValue
    @Column(name = "BOARD_ONEENTITYMANYTABLE_ID")
    private Long id;
    private String title;

    @Column(table = "BOARD_DETAIL_ONEENTITYMANYTABLE")
    /*
        컬럼을 이용해서 board_detail테이블의 컬럼에 매핑했다. 테이블을 지정하지 않으면 board로 빨려 들어간다.
     */
    private String content;

}
