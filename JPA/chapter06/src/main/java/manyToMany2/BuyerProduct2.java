package manyToMany2;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@IdClass(BuyerProduct2ID.class)
/*
    복합키를 사용하면서 단순히 하나의 필드로 이를 식별하는 것이 아니라 별도의 식별자 클래스를 만들어서 사용해야 한다는 것을 알 수 있다.
    복합키는 별도의 식별자 클래스를 만들어줘야하는데 이는 Serializable을 구현하며, HashCode, Equals를 재구현하여
    객체가 서로 같음을 식별하도록 구성된다.

    @IdClass 혹은 @EmbeddedId를 사용하는 방법이 있다.
 */
public class BuyerProduct2 {
// 아래의 구성을 보면 두 개의 ID가 있는 것으로 보인다. 이를 통해서 현재 이 엔티티에서 복합키를 사용한다는 것을 알 수 있다.
// 추가적으로 각 키들이 외래키를 기본키로 사용하는 것을 알 수 있다. 이는 결과적으로 식별관계임을 알 수 있다.
    @Id
    @ManyToOne
    @JoinColumn(name = "BUYER2_ID")
    private Buyer2 buyer2;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT2_ID")
    private Product2 product2;





    private int orderAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
}
