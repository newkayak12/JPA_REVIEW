package entity;

import entity.baseEntity.BaseEntity_07;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item_07 extends BaseEntity_07 {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_07_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

//    category
    @ManyToMany(mappedBy = "item07List")
    private List<Category_07> category07List = new ArrayList<>();



}
