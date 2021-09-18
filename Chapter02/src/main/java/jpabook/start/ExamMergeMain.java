package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {
    static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("hibernate");


    public static void main(String[] args) {
        MemberEntity memberEntity = createMember("memberA", "회원1");
//        영속성 컨택스트에 들어갔다 나와서 준영속 상태임

        memberEntity.setName("회원명 변경");
//        준영속 상태이기 떄문에 이름 수정이 영속성 컨테이너나 데이터베이스에 반영되지 않음


        mergeMember(memberEntity);
    }

    static MemberEntity createMember(String id, String userName){
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        MemberEntity entity = MemberEntity.builder().id(id).age(19).name(userName).build();
        System.out.println("영속성 컨텍스트에 들어감. "  + entity);
        em1.persist(entity);
//        영속성 컨테이너에 entity 포함
        tx1.commit();

        em1.close();
//        영속성 컨텍스트1 종료 -> entity는 준영속 상태로 전환

        return entity;

    }

    static void mergeMember(MemberEntity memberEntity){
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();

//        준영속 -> 영속
        MemberEntity mergeMember = em2.merge(memberEntity);
//      memberEntity 와 mergeMember를 다른 객체가 되어버린다. 따라서,
//        memberEntity = em2.merge(memberEntity)가 낫다.

//       비영속 -> 영속(merge)
        MemberEntity mem2 = em2.merge(MemberEntity.builder().id("비영속").age(22).name("비영속이").build());
        System.out.println("비영속 -> 영속이 영속 컨텍스트에 있니?" + em2.contains(mem2));
        tx2.commit();

//        준영속 상태
        System.out.println("member :: " + memberEntity.getName());

//        영속 상태
        System.out.println("mergeMember :: "+ mergeMember.getName());

        System.out.println("em2 contains member :: " + em2.contains(memberEntity));
        System.out.println("em2 contains mergeMember :: "+em2.contains(mergeMember));
        
//        여러 번 실행했을 때를 위한 코드
        tx2.begin();
        em2.remove(mergeMember);
        em2.remove(mem2);
        tx2.commit();

        em2.close();
//        영속성 컨텍스트2 종료


    }
}
