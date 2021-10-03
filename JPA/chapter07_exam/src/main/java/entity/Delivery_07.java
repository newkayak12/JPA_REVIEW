package entity;

import entity.baseEntity.BaseEntity_07;
import entity.enums.DeliverStatus_07;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Delivery_07 extends BaseEntity_07 {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_07_ID")
    private Long id;

//    order
    @OneToOne(mappedBy = "delivery07")
    private Order_07 order07;

    private String city;

    private String street;

    private String zipcode;

    private DeliverStatus_07 deliverStatus;
}
