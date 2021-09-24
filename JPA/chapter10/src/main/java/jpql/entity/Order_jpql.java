package jpql.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Setter
@Getter
@Entity
public class Order_jpql {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_JPQL_ID")
    private Long id;
    private int orderAmount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_JPQL2_ID")
    Member_jpql2 member;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUCT_JPQL_ID")
    private Product_jpql product;

    @Embedded
    Address_jpql address;

    public void addMember(Member_jpql2 member){
        if(member!=null){
            member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }
}
