package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Delivery06 {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY06_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery06")
    private Order06 order06;

    private String city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
