package entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Item06 {

    @Id
    @GeneratedValue
    @Column(name = "ITEM06_ID")
    private Long id;

    private String name;

    private int price;

    private int StockQuantity;

    @ManyToMany(mappedBy = "item06s")
    private List<Category06> category06s = new ArrayList<>();


}
