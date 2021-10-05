package entityGraph.entity;

import entity.baseEntity.BaseEntity_08;
import entity.enums.DeliverStatus_08;
import entity.valueType.Address_09;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address_09 address09;
    private DeliverStatus_08 deliverStatus;
}
