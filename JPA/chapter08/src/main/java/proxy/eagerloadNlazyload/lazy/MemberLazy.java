package proxy.eagerloadNlazyload.lazy;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class MemberLazy {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_LAZY_ID")
    private Long id;

    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
//    지연로딩으로 실제로 필요한 시점에 필요한 엔티티를 DB에서 로드한다.
    /*
            Member를 조회하면 Member 이외의 Team은 포함되지 않는다. 대신 teamProxy에 프록시 객체를 넣어둔다.
            그리고 해당 객체를 실제로 사용할 때가 되서야 로드하기 시작한다.

            >> 조회 대상이 영속성 컨텍스트에 이미 있으며 프록시 객체를 사용하는 이유가 없다.
     */
    @JoinColumn(name = "TEAM_LAZY",nullable = false)
    private TeamLazy teamProxy;



}
