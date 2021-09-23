package joinTable.oneEntityManyTable;

import javax.persistence.*;

@Entity
@Table(name = "BOARD_ONEENTITYMANYTABLE")
@SecondaryTable(name = "BOARD_DETAIL_ONEENTITYMANYTABLE", pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ONEENTITYMANYTABLE_ID"))
/*
    Table을 이용해서 board 테이블을 연결했다.

    @SecondaryTable을 이용해서 하나의 테이블 추가적으로 연결했다. 
 */
public class Board_OneEntityManyTable {
    @Id
    @GeneratedValue
    @Column(name = "BOARD_ONEENTITYMANYTABLE_ID")
    private Long id;
    private String title;

    @Column(table = "BOARD_DETAIL_ONEENTITYMANYTABLE")
    private String content;

}
