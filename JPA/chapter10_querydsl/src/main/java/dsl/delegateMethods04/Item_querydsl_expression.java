package dsl.delegateMethods04;

import com.mysema.query.annotations.QueryDelegate;
import com.mysema.query.types.expr.BooleanExpression;
import dsl.entity.Item_queryDSL;
import dsl.entity.QItem_queryDSL;

public class Item_querydsl_expression {

    @QueryDelegate(Item_queryDSL.class)
    public static BooleanExpression isExpensive(QItem_queryDSL item, Integer price){
        return item.price.gt(price);
//        아예 name쿼리 같은 느낌인가보네
    }
}
