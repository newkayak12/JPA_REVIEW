package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class OrderItem06 {
    @Id
    @GeneratedValue
    @Column(name = "ORDERITEM06_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER06_ID")
    private Order06 order06;

    @OneToMany
    @JoinColumn(name = "ITEM06_ID")
    private Item06 item06;

    private int orderPrice;

    private int count;
}
