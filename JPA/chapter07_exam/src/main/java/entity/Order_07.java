package entity;

import entity.baseEntity.BaseEntity_07;
import entity.enums.OrderStatus_07;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Order_07 extends BaseEntity_07 {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_07_ID")
    private Long id;

//    member
    @ManyToOne
    @JoinColumn(name = "MEMBER_07_ID")
    private Member_07 member07;

//    orderItem
    @OneToMany(mappedBy = "order07")
    private List<OrderItem_07> orderItem07List = new ArrayList<>();

//    delivery
    @OneToOne
    @JoinColumn(name = "DELIVERY_07_ID")
    private Delivery_07 delivery07;

    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus_07 orderstatus;

//    연관관계 메소드
    public void setMember(Member_07 member){
        if(this.member07 != null){
            this.member07.getOrders().remove(this);
        }
        this.member07 = member;
        member.getOrders().add(this);
    }
    public void setOrderItem(OrderItem_07 orderItem){
        orderItem07List.add(orderItem);
        orderItem.setOrder07(this);
    }
    public void setDelivery(Delivery_07 delivery07){
        this.delivery07 = delivery07;
        delivery07.setOrder07(this);
    }
}
