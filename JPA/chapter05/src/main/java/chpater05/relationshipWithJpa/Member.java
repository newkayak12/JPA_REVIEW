package chpater05.relationshipWithJpa;

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
@Table(name = "MEMBER")
public class Member {
    public Member(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

/*
    @JoinColumn : 외래키 매핑에서 사용한다.
        - name : 매핑할 외래 키 이름 : 필드명_참조하는 테이블의 기본 키 컬럼명
        - referencedColumnName : 외래키가 참조하는 대상 테이블의 컬럼명 : 참조하는 테이블의 기본 키 컬럼명
        - foreignKey(DDL) : 외래키 제약 조건을 직접 지정할 수 있다. (테이블을 생성할 떄) :
        - unique/nullable/insertable/updatable/columnDefinition/table :: @Column의 속성 참조

        - 생략 :: 외래키 찾는 기본 전략을 사용 :: team_TEAM_ID;

    @MayToOne : 다:1 관계에서 사용한다.
        - optional : false로 설정하면 연관된 엔티티가 항상 있어야한다. : true
        - fetch : 글로벌 페치 전략을 사용한다. :  @ManyToOne :: FetchType.EAGER // @OneToMany :: FetchType.LAZY
        - cascade : 영속성 전이 기능을 사용
        - targetEntity : 연관된 엔티티의 타입정보를 성정한다.
            >>@OneToMany                             @OnetoMany(targetEntity=Member.class)
                private List<Member> members   =>     private List members;

 */


}
