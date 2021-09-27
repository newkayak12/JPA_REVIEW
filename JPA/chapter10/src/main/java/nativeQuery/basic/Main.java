package nativeQuery.basic;

import nativeQuery.entity.Hobby_Native;
import nativeQuery.entity.Member_Native;

import javax.persistence.*;
import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
//    select();
//    selectValue();

//        selectResult();

        namedQuery();
    }
    public static void insert(){
        Member_Native m1  = new Member_Native();
        m1.setName("m1");
        m1.setAge(28);

        Hobby_Native h1 = new Hobby_Native();
        Hobby_Native h2 = new Hobby_Native();
        h1.setHobby("guitar");
        h1.setHowLong(5);
        h2.setHobby("game");
        h2.setHowLong(2);

        h1.addMember(m1);
        h2.addMember(m1);

        Member_Native m2  = new Member_Native();
        m2.setAge(25);
        m2.setName("m2");

        Hobby_Native h3 = new Hobby_Native();
        Hobby_Native h4 = new Hobby_Native();
        h3.setHobby("ANIME");
        h3.setHowLong(2);
        h4.setHobby("RUNNING");
        h4.setHowLong(8);

        h3.addMember(m2);
        h4.addMember(m2);

        tx.begin();
        em.persist(m1);
        em.persist(m2);
        tx.commit();


    }
    public static void select(){
        insert();

        String sql = "SELECT MEMBER_NATIVE_ID, NAME, AGE FROM NATIVE_MEMBER WHERE AGE > :Age";

        Query nativeQuery = em.createNativeQuery(sql,Member_Native.class).setParameter("Age", 20);
        List<Member_Native> list = nativeQuery.getResultList();
        System.out.println(list);

        String sql2 = "SELECT MEMBER_NATIVE_ID, HOBBY_NATIVE_ID, HOBBY, HOW_LONG FROM HOBBY_NATIVE";
        Query native2 = em.createNativeQuery(sql2, Hobby_Native.class);
        List<Hobby_Native> list2 = native2.getResultList();
        System.out.println(list2);
    }

    public static void selectValue(){
        insert();
        String sql = "SELECT MEMBER_NATIVE_ID, HOBBY_NATIVE_ID, HOW_LONG, HOBBY FROM HOBBY_NATIVE";
        List<Object[]> list = em.createNativeQuery(sql).getResultList();
        for(Object[] o : list){
            for(Object os : o){
                System.out.println(os);
            }
        }
/*
    스칼라 값이므로 영속성 컨텍스트에서 관리하지 않는다. 마치 JDBC로 데이터를 조회한 것과 유사하다.
 */
    }

    public static void selectResult(){
        insert();
        String sql = "SELECT  h.HOW_LONG, h.HOBBY, m.* FROM HOBBY_NATIVE h LEFT JOIN NATIVE_MEMBER m on h.MEMBER_NATIVE_ID = m.MEMBER_NATIVE_ID";
        Query nativeQuery = em.createNativeQuery(sql, "HobbyWithMember");
        List<Object[]> resultList = nativeQuery.getResultList();
        for(Object[] objs : resultList){
            for(Object o : objs){
                System.out.println(o);
            }
        }
        /*
            Member_Native(id=1, name=m1, age=28, hobby=[Hobby_Native{howLong=5, hobby='guitar'}, Hobby_Native{howLong=2, hobby='game'}])
            5
            guitar

            위와 같이 엔티티와 스칼라 둘 다 조회할 수 있다.
         */
    }

    public static void namedQuery(){
        insert();
        TypedQuery<Member_Native> nativeQuery = em.createNamedQuery("Member.selectSQL", Member_Native.class);
        List<Member_Native> members = nativeQuery.getResultList();
        System.out.println(members);
// JPQL의 NamedQuery와 같은 createNamedQuery를 사용하기 때문에 TypeQuery를 사용할 수 있다.

        List<Object[]> objs = em.createNamedQuery("Hobby_selectQuery").getResultList();
        for(Object[] obj : objs) {
            for (int i = 0; i < obj.length; i++) {
                System.out.println(obj[i]);
            }
        }
    }
}
