package chpater05.relationshipWithJpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//@Entity
public class Team {
    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
//    왜 mappedBy 속성이 필요한가?
    /*
        정확히 말하면 객체 간 양방향 관계는 없다. 단순히 로직으로 묶어서 그렇게 '보이도록 한 것'이다.
        테이블은 외래 키 하나로 두 테이블의 연관관계를 관리한다.
        엔티티는 방향성이 있다. 단방향으로 매핑하면 한 곳에서만 객체 순회를 할 수 있다.
        엔티티를 양방향 연관관계로 설정해 두면 객체 참조는 둘 인데 외래 키는 하나이다. 따라서 여기서 간극이 발생한다.
        그리하여 JPA에서는 연관관계를 가진 두 객체 중 하나를 선정하여 테이블의 외래키를 관리하도록 둔다. 이를 연관관계에서 주인이라고 한다.

        연관관계의 주인만이 DB연관관계와 매핑되고 외래키를 관리(등록, 수정, 삭제)할 수 있다. 반대쪽은 읽기만 할 수 있다.

        >> 주인을 정할지는 mappedBy로 정해진다.
        1. 주인은 mappedBy를 사용하지 않는다.
        2. 주인이 아니면 mappedBy 속성으로 속성의 값으로 연관관계를 상정해줘야한다.
        (HAS_A관계로 추측됨)


        >> 선정 기준

        연관관계의 주인은 테이블에 외래 키가 있는 곳으로 정해야한다. >> 여기서는 회원이 외래키를 가지고 있다. 따라서  회원이 주인이 된다.

        !!!!!!!!!!!!!!!!!!!!!
        물론 깩체 관점에서 양쪽 방향에 모두 값을 입력해주는 것이 가장 안전하다. >> JPA이용하지 않는 POJO일 때 문제가 생길 수 있다.

        ex)
         Team1 team1 = new Team("team1", "T1");
         Member member1 = new Member("member1", "m1");
         Member member2 = new Member("member2", "m2");

         member1.setTeam(team1);
         member2.setTeam(team1);
         ----------> 연관관계 설정

         List<Member> members = team1.getMembers();
         System.out.println(member.size()); >>>>> 0이 나온다.


         이 코드를 양쪽의 모든 관계를 설정하면

          Team1 team1 = new Team("team1", "T1");
         Member member1 = new Member("member1", "m1");
         Member member2 = new Member("member2", "m2");

         member1.setTeam(team1);
         team1.getMembers().add(member1);
         member2.setTeam(team1);
         team1.getMembers().add(member2);
         ----------> 연관관계 설정

         가 된다 .

         이를 JPA로 바꾸면

         ex)
             Team1 team1 = new Team("team1", "T1");
             em.persist(team1);
             Member member1 = new Member("member1", "m1");
             Member member2 = new Member("member2", "m2");

             member1.setTeam(team1);
             team1.getMembers().add(member1);
             em.persist(member1);

             member2.setTeam(team1);
             team1.getMembers().add(member2);
             em.persist(member2);
             ----------> 연관관계 설정


            결론적으로 양쪽 모두 연관관계를 주는 것이 POJO일 떄도 같은 결과가 나오는 것을 보장해준다.

            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Member 객체로 간다.
            MEMBER객체 참조
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            1. 단방향 매핑만으로 DB와 연동성은 해소
            2. 양방향으로 만들면 객체 그래프 탐색이 가능
            3. 양방향 관계를 추구하면 객체에서 양쪽 방향을 모두 관리해야한다.
            +a : 로직 구성 시 필요에 따라서 선택하면 된다.
     */
    private List<Member> members = new ArrayList<>();
}
