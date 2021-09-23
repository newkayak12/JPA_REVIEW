package proxy.eagerloadNlazyload.example;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class OrderExample {
    @Id
    @Column(name = "ORDER_EXAMPLE_ID")
    private String id;
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_EXAMPLE_ID")
    private  MemberExample members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_EXAMPLE_ID")
    private ProductExample product;

    public MemberExample addMember(MemberExample member){
        if(member != null){
            System.out.println(member.getOrders()==null);
            member.getOrders().remove(this);
        }
        this.members = member;
        member.getOrders().add(this);
        return member;
    }
}
