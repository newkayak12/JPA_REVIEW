package oneToMany_oneWay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ORDERS")
public class OrderExam {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberExam member;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @OneToMany(mappedBy = "order")
    private List<OrderItemExam> orderItems = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    OrderStatusExam status;

    public void setMember(MemberExam member){
        if(this.member!=null){
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItemExam orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
