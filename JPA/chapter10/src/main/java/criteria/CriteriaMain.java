package criteria;

import jpql.Member_jpql;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
//        userCriteria();
        conditionalExam();

    }
    public static void userCriteria(){
        Member_criteria m = new Member_criteria();
        m.setName("kim");

        tx.begin();
        em.persist(m);
        tx.commit();
// Criteria 사용 준비
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> query = cb.createQuery(Member_criteria.class);
// 조회를 시작할 클래스를 잡는 루트 클래스
        Root<Member_criteria> mQuery = query.from(Member_criteria.class);
//  쿼리를 생성
        CriteriaQuery<Member_criteria> criQuery = query.select(mQuery).where(cb.equal(mQuery.get("name"), "kim"));
        List<Member_criteria> mlist = em.createQuery(criQuery).getResultList();
        System.out.println(mlist);
    }

    /*
        Criteria가 가진 장점이 많지만 문제는 굉장히 복잡하다


     */
    public static void basicCriteria(){
//        JPQL : select m from Member m
        CriteriaBuilder cb = em.getCriteriaBuilder();
//       Criteria 쿼리 빌더

        CriteriaQuery<Member_criteria> cq = cb.createQuery(Member_criteria.class);
//        생성 반환 타입 지정

        Root<Member_criteria> m = cq.from(Member_criteria.class); // from 절 작성
        cq.select(m); //select 절

        TypedQuery<Member_criteria> query = em.createQuery(cq);
        List<Member_criteria> members = query.getResultList();
    }


    public static void conditionalCriteria(){
//        JPQL : select m from Member m where m.name = '회원1' order by m.age desc;

        CriteriaBuilder cb = em.getCriteriaBuilder();
//       Criteria 쿼리 빌더

        CriteriaQuery<Member_criteria> cq = cb.createQuery(Member_criteria.class);
//        생성 반환 타입 지정

        Root<Member_criteria> m = cq.from(Member_criteria.class); // from 절 작성
        Predicate userNameEqual = cb.equal(m.get("name"),"회원1");//where
        Order ageDesc = cb.desc(m.get("age"));//order by


        cq.select(m).where(userNameEqual).orderBy(ageDesc); //select 절

        TypedQuery<Member_criteria> query = em.createQuery(cq);
        List<Member_criteria> members = query.getResultList();
        /*
            쿼리 루트는 조회의 시작점이다.
            Criteria에서 사용되는 특별한 별칭이다.
            별칭은 엔티티에만 부여할 수 있다.
         */
    }


    public static void conditionalExam(){
        Member_criteria m1 = Member_criteria.builder().age(21).name("m1").build();
        Member_criteria m2 = Member_criteria.builder().age(19).name("m2").build();
        Member_criteria m3 = Member_criteria.builder().age(18).name("m3").build();
        Member_criteria m4 = Member_criteria.builder().age(23).name("m4").build();
        Member_criteria m5 = Member_criteria.builder().age(22).name("m5").build();
        Member_criteria m6 = Member_criteria.builder().age(16).name("m6").build();

        tx.begin();
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.persist(m4);
            em.persist(m5);
            em.persist(m6);
        tx.commit();

//        select m from Member m where m.age>19 order by m.age desc\

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> cq = cb.createQuery(Member_criteria.class);
//        반환 타입을 비워두면 Object이다. 물론 Object[]를 반환 타입으로 잡을 수도 있다.


        CriteriaQuery<Object> cq2 = cb.createQuery();
//        반환타입을 Object로 두고 비워놓을 수도 있다.
//        그 후 List<Object> result = em.createQuery(cq2).getResultList();


        Root<Member_criteria> m = cq.from(Member_criteria.class);

        Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),19);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        TypedQuery<Member_criteria> query = em.createQuery(cq);

        List<Member_criteria> mList = query.getResultList();

        System.out.println(mList);
    }


    public static void select(){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member_criteria> cq = cb.createQuery(Member_criteria.class);
            Root<Member_criteria> m = cq.from(Member_criteria.class);

            cq.select(m);
//            단 건

            cq.multiselect(m.get("name"), m.get("age"));
//            여러 건

            CriteriaQuery<Object> cq2 =cb.createQuery();
            cq2.select(cb.array(m.get("name"), m.get("age")));
//            이렇게 여러 건을 받을 수도 있다.
    }

    public static void distinct(){
        // select distinct m.name, m.age from Member m

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member_criteria> m = cq.from(Member_criteria.class);

        cq.multiselect(m.get("name"), m.get("age")).distinct(true);
//        cq.select(cb.array(m.get("name"), m.get("age")))).distinct(true) 와 같다.
        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

    }



    public static void newNConstruct(){
//        select new criteria.Member_criteria(m.name, m.age) from Member m
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> cq = cb.createQuery(Member_criteria.class);
        Root<Member_criteria> m = cq.from(Member_criteria.class);

        cq.select(cb.construct(Member_criteria.class, m.get("name")));

        TypedQuery<Member_criteria> query = em.createQuery(cq);
        List<Member_criteria> resultList = query.getResultList();
    }

    public static void tuple(){
//        select m.name, m.age from Member_criteria m
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//        == CriteriaQueyr<Tuple> cq = cb.createQuery(Tuple.class);

        Root<Member_criteria> m = cq.from(Member_criteria.class);
        cq.multiselect(
                m.get("name").alias("userName"),
                m.get("age").alias("age")
        );

        TypedQuery<Tuple> query = em.createQuery(cq);
        List<Tuple> resultList = query.getResultList();

        for(Tuple tupe : resultList){
            String userName = tupe.get("userName", String.class);
            Integer age = tupe.get("age", Integer.class);
//            Criteria는 map과 비슷한 Tuple이라는 특별한 반환 객체를 제공한다.
            /*
                튜플은 튜플의 검색 키로 사용할 튜플 전용 별칭을 필수적으로 할당해야한다. .alias()
                선언해둔 튜플 별칭으로 데이터를 조회할 수 있다.

                Tuple이 Object[]보다 안전하다.
             */
        }


    }



    public static void tupleEntity(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        Root<Member_criteria> m = cq.from(Member_criteria.class);

        cq.select(
                cb.tuple(
                        m.alias("m"),
                        m.get("name").alias("userName")
                )
        );

        TypedQuery<Tuple> query = em.createQuery(cq);
        List<Tuple> list = query.getResultList();
        for(Tuple tuple : list){
            Member_criteria mObj = tuple.get("m", Member_criteria.class);
            String userName = tuple.get("userName", String.class);
        }

    }

    public static void groupBy(){
//        select m.team.name, max(m.age), min(m.age) from Member m group by m.team.name

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member_criteria> m = cq.from(Member_criteria.class);

        Expression maxAge = cb.max(m.<Integer>get("age"));
        Expression minAge = cb.min(m.<Integer>get("age"));

        cq.multiselect(m.get("team").get("name"), maxAge, minAge);
        cq.groupBy(m.get("team").get("name"));

        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();
    }

    public static void having(){
//        select m.team.name, max(m.age), min(m.age) from Member m group by m.team.name having max(m.age) > 10;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member_criteria> m = cq.from(Member_criteria.class);

        Expression maxAge = cb.max(m.<Integer>get("age"));
        Expression minAge = cb.min(m.<Integer>get("age"));

        cq.multiselect(m.get("team").get("name"), maxAge, minAge);
        cq.groupBy(m.get("team").get("name")).having(cb.gt(minAge,10));

        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

    }
    public static void orderby(){
//        select m.team.name, max(m.age), min(m.age), m.age from Member m group by m.team.name having max(m.age) > 10 order by m.age DESC;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member_criteria> m = cq.from(Member_criteria.class);

        Expression maxAge = cb.max(m.<Integer>get("age"));
        Expression minAge = cb.min(m.<Integer>get("age"));

        cq.multiselect(m.get("team").get("name"), maxAge, minAge, m.get("age")).orderBy(cb.desc(m.get("age")));
//        desc
        cq.groupBy(m.get("team").get("name")).having(cb.gt(minAge,10));

        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

    }

    public static void join(){
//        select m, t from Member m inner join m.team t where t.name = '팀1'
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member_criteria> m = cq.from(Member_criteria.class);
        Join<Member_criteria,Team_criteria> t = m.join("team", JoinType.INNER);
//JoinType.INNER, LEFT, RIGHT가 있다.
        cq.multiselect(m,t).where(cb.equal(t.get("name"), "팀1"));

        TypedQuery<Object[]> resultList = em.createQuery(cq);
        Object[] a = resultList.getSingleResult();

    }

    public static void subQuery(){
//        select m from Member m where m.age >=  (select AVG(m2.age) from Member m2)
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> mainquery = cb.createQuery(Member_criteria.class);
        Subquery<Double> subquery = mainquery.subquery(Double.class);

        Root<Member_criteria> m2 = subquery.from(Member_criteria.class);
        subquery.select(cb.avg((m2.<Integer>get("age"))));
//        subquery

        Root<Member_criteria> m1 = mainquery.from(Member_criteria.class);
        mainquery.select(m1).where(cb.ge(m1.<Integer>get("age"),subquery));

        TypedQuery<Member_criteria> tq = em.createQuery(mainquery);
        List<Member_criteria> list = tq.getResultList();

    }

    public static void correlateSubQuery(){
//        jpql select m from Member m where exists (select t from m.team t where t.name = '팀1'
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member_criteria> main = cb.createQuery(Member_criteria.class);

//        서브쿼리에서 사용하는 m
        Root<Member_criteria> m = main.from(Member_criteria.class);

//        서브쿼리 생성
        Subquery<Team_criteria> sub = main.subquery(Team_criteria.class);
        Root<Member_criteria> subM = sub.correlate(m);
//        연관성 준다.
        Join<Member_criteria,Team_criteria> t = subM.join("team");
//      그걸로 조인해서 값을 둔다.

//      서브쿼리 작성
        sub.select(t).where(cb.equal(t.get("name"),"팀1"));

//        메인쿼리
        main.select(m).where(cb.exists(sub));
        
        List<Member_criteria> lsit = em.createQuery(main).getResultList();
    }
}
