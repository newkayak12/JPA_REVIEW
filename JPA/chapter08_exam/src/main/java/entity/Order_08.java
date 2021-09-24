package entity;

import entity.baseEntity.BaseEntity_08;
import entity.enums.OrderStatus_08;
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
public class Order_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_08_ID")
    private Long id;

//    member
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_08_ID")
    private Member_08 member08;

//    orderItem
    @OneToMany(mappedBy = "order08", cascade = CascadeType.ALL)
    private List<OrderItem_08> orderItem08List = new ArrayList<>();

//    delivery
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_08_ID")
    private Delivery_08 delivery08;

    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus_08 orderstatus;

//    연관관계 메소드
    public void addMember(Member_08 member){
        if(this.member08 != null){
            this.member08.getOrders().remove(this);
        }
        this.member08 = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem_08 orderItem){
        orderItem08List.add(orderItem);
        orderItem.setOrder08(this);
    }
    public void addDelivery(Delivery_08 delivery08){
        this.delivery08 = delivery08;
        delivery08.setOrder08(this);
    }
}
