package entityGraph.entity;

import entity.baseEntity.BaseEntity_08;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_07_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

//    category
    @ManyToMany(mappedBy = "item08List")
    private List<Category_08> category08List = new ArrayList<>();



}
