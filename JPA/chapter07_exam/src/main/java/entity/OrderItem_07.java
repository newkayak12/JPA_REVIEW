package entity;

import entity.baseEntity.BaseEntity_07;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class OrderItem_07 extends BaseEntity_07 {
    @Id
    @GeneratedValue
    @Column(name = "ORDERITEM_07_ID")
    private Long id;

//    Item
    @ManyToOne
    @JoinColumn(name = "ITEM_07_ID")
    private Item_07 item07;

//    Order
    @ManyToOne
    @JoinColumn(name = "ORDER_07_ID")
    private Order_07 order07;

    private int orderPrice;

    private int count;
}
