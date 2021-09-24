package ElementCollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        enroll();
        System.out.println("++++++++++++++++");
        update();

    }

    public static void enroll(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        Member_ElementCollection member = new Member_ElementCollection();

        member.setHomeAddress(new Address_ElementCollection("통영", "뭉돌해수욕장", "660-123"));
        member.getFavoriteFoods().add("짬뽕");
        member.getFavoriteFoods().add("짜장");
        member.getFavoriteFoods().add("탕수육");

        member.getAddressHistory().add(new Address_ElementCollection("서울", "강남", "123-123" ));
        member.getAddressHistory().add(new Address_ElementCollection("서울", "강북", "000-000" ));
        tx.begin();
        em.persist(member);
        tx.commit();

        /*

                member insert 1번
                member.homeAddress 1 번

                member.favoriteFood 3번
                member.addressHistory 3번

                총 8번의 INSERT
                따라서 값 타입 컬렉션은 영속성 전이와 고아 객체 제거 기능을 필수로 가진다.

                추가적으로 갑 타입 컬렉션도 조회 시 페치 전략을 수립할 수 있는데 기본이 LAZY이다.

         */
    }
    public static void update(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member_ElementCollection member = em.find(Member_ElementCollection.class, 1L);
        member.setHomeAddress(new Address_ElementCollection("신도시", "신도시", "12345"));

        Set<String> favfood = member.getFavoriteFoods();
        favfood.remove("탕수육");
        favfood.add("치킨");

        List<Address_ElementCollection> adH = member.getAddressHistory();
        adH.remove(new Address_ElementCollection("서울", "기존 주소","123-123" ));
        adH.add(new Address_ElementCollection("새로운 도시", "새로운 주소", "1234-1234"));
        tx.commit();

    }
}
