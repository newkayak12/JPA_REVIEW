package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
public class OrderItemExam {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    ItemExam item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderExam order;

    private int orderPrice;

    private int count;
}
