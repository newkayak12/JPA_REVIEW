package jpql.join.pathExpression;

import jpql.entity.Team_jpql;

import javax.persistence.*;

@Entity
public class User_pathField {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String userName; // 상태 필드
    private Integer age; //상태필드

//    @ManyToOne
//    private Team team >> 연관 필드(단일 값 연관 필드)

//    @OneToMany
//    private List<Order> orders >> 연관 필드(컬렉션 값 연관 필드)

    /*
        상태 필드 : t.userName, t.age
        단일 값 필드 : m.team
        컬렉션 값 연관 필드 : m.orders
     */

}
