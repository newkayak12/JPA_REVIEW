package manyToMany3;

import lombok.*;
import manyToMany2.BuyerProduct2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class Buyer3 {
    @Id
    @Column(name = "BUYER3_ID")
    private String id;

    private String userName;

    @OneToMany(mappedBy = "buyer3")
    private List<Order3> orders = new ArrayList<>();

}
