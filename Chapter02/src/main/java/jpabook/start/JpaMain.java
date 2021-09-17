package jpabook.start;

import jdk.swing.interop.SwingInterOpUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
//        엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
        // JDBCTemplate와 거의 비슷한 느낌이네? >> abstractFactory, FactoryMethod사용하는 Template패턴
//        엔티티 매니저 생성::THREAD 상 공유하면 안됨..
        EntityManager em = emf.createEntityManager();

//        트랜잭션 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

    private static void logic(EntityManager em ){
        String id = "id1";
        MemberEntity member = MemberEntity.builder().id(id).name("예진").age(26).build();

//        등록
        em.persist(member);

//        수정
        member.setAge(27);

//        한 건 조회
        MemberEntity findMember = em.find(MemberEntity.class, id);
        System.out.println(findMember);


        List<MemberEntity> members = em.createQuery("SELECT m FROM MemberEntity m", MemberEntity.class).getResultList();
//        테이블이 아닌 엔티티 객체에 검색을 해야한다. !!!!

        System.out.println("member.size() :  "+ members.size());

        em.remove(member);
    }

}
