package manyToMany.biDirection;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class ProductBiDirection {
    @Id
    @Column(name = "PRODUCTBIDIRECTION_ID")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "products")
    private List<BuyerBiDirection> buyerBiDirections = new ArrayList<>();

    public ProductBiDirection(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
