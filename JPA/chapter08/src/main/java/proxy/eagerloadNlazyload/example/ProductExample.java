package proxy.eagerloadNlazyload.example;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ProductExample {
    @Id
    @Column(name = "PRODUCT_EXAMPLE_ID")
    private String id;
    private String productName;
    private int productPrice;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    List<OrderExample> orders = new ArrayList<>();

}
