package manyToMany2;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Buyer2 {
    @Id
    @Column(name = "BUYER2_ID")
    private String id;

    private String userName;

    @OneToMany(mappedBy = "buyer2")
    private List<BuyerProduct2> buyerProduct2s;

}
