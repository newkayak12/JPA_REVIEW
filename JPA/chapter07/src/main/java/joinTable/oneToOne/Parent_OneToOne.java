package joinTable.oneToOne;

import javax.persistence.*;

@Entity
public class Parent_OneToOne {
    @Id
    @Column(name = "PARENT_ONETOONE_ID")
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD_ONETOONE", joinColumns = @JoinColumn(name = "PARENT_ONETOONE_ID"), inverseJoinColumns = @JoinColumn(name = "CHILD_ONETOONE_ID"))
    private Child_OneToOne child_oneToOne;
    /*
        name : 매핑할 조인 테이블 이름
        joinColumns : 현재 엔티티를 참조하는 외래 키
        inverseJoinColumns : 반대방향 엔티티를 참조하는 외래 키
     */

}
