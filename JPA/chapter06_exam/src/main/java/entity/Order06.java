package entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Order06 {
    @Id
    @GeneratedValue
    @Column(name = "ORDER06_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER06_ID")
    private Member06 member06;

    @OneToMany(mappedBy = "order06")
    private List<OrderItem06> orderItem06s = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "DELIVERY06_ID")
    private Delivery06 delivery06;


    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

//    연관관계 메소드
    public void setMember(Member06 member){
        if(this.member06 != null){
            this.member06.getOrder06s().remove(this);
        }
        this.member06 = member;
        member.getOrder06s().add(this);
    }

    public void setOrderItem(OrderItem06 orderItem06){
        orderItem06s.add(orderItem06);
        orderItem06.setOrder06(this);
    }

    public void setDelivery(Delivery06 delivery06){
        this.delivery06 = delivery06;
        delivery06.setOrder06(this);
    }
}
