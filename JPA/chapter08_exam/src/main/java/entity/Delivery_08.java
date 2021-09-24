package entity;

import entity.baseEntity.BaseEntity_08;
import entity.enums.DeliverStatus_08;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Delivery_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_08_ID")
    private Long id;

//    order
    @OneToOne(mappedBy = "delivery08")
    private Order_08 order08;

    private String city;

    private String street;

    private String zipcode;

    private DeliverStatus_08 deliverStatus;
}
