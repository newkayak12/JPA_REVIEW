package entityGraph.entity;

import entity.baseEntity.BaseEntity_08;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OrderItem_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "ORDERITEM_08_ID")
    private Long id;

//    Item
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_08_ID")
    private Item_08 item08;

//    Order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_08_ID")
    private Order_08 order08;

    private int orderPrice;

    private int count;
}
