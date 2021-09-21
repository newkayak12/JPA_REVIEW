package manyToMany3;

import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

@Entity
public class Order3 {
    @Id
    @GeneratedValue
    @Column(name = "ORDER3_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BUYER3_ID")
    private Buyer3 buyer3;

    @ManyToOne
    @JoinColumn(name = "PRODUCT3_ID")
    private Product3 product3;

    /*
         근데 이러면.. buyer3_id 가 1 product3_id 가 A인 컬럼이
         pk만 다르고 여러 개 들어갈 수 있는데 괜찮은지 모르겠다?
    */

    private int orderAmount;
}
