package proxy.eagerloadNlazyload.eager;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class MemberEager {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_EAGER_ID")
    private Long id;

    private String userName;

    @ManyToOne(fetch = FetchType.EAGER)
//    위와 같이 바로 로드하게 할 수 있다.
    /*
        쿼리 결과를 보면 LEFT OUTER JOIN을 사용한다.  이는 INNER JOIN으로 조회했을 떄 누락될 수도 있는 row를 고려해서이다.
        만약  NN이라면 누락되는 값이 없다는 것이 보장된다. 따라서, 굳이 outer join을 사용하지 않을 수 있도록 'nullable = false'
        로 이를 방지해주면 된다.
     */
    @JoinColumn(name = "TEAM_EAGER_ID",nullable = false)
    private TeamEager teamProxy;



}
