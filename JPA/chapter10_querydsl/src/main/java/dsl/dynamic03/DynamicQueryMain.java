package dsl.dynamic03;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import dsl.entity.Item_queryDSL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static dsl.entity.QItem_queryDSL.item_queryDSL;

public class DynamicQueryMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();
    public static void main(String[] args) {
        dynamicQuery();
    }
    public static void dynamicQuery(){
        /*
            com.mysema.query.BooleanBuilder를 사용하면 특정 조건에 따른 동적 쿼리를 작성할 수 있다.
         */
        String detailParam = "고급";
        Integer priceParam = 10000;
        JPAQuery query = new JPAQuery(em);

        BooleanBuilder builder = new BooleanBuilder();
        if(detailParam!=null){
//            예제에서는 org.apache.commons.lang.StringUtils를 사용했다.
                builder.and(item_queryDSL.detail.eq(detailParam));
        }
        if(priceParam != null){
            builder.and(item_queryDSL.price.gt(priceParam.intValue()));
        }

        List<Item_queryDSL> list = query.from(item_queryDSL).where(builder).list(item_queryDSL);

        System.out.println(list);
        /*
            detailParam, priceParam을 파라미터로 받으면 동적 쿼리가 가능할 것
         */
    }
}
