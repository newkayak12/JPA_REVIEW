package entity;

import entity.baseEntity.BaseEntity_08;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Category_08 extends BaseEntity_08 {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_08_ID")
    private Long id;

    private String name;

//    Items
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM_08", joinColumns = @JoinColumn(name = "CATEGORY_08_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_08_ID"))
    private List<Item_08> item08List = new ArrayList<>();

//    Parent
    @ManyToOne
    @JoinColumn(name = "PARENTS_08_ID")
    private Category_08 parent;

//    child
    @OneToMany(mappedBy = "parent")
    private List<Category_08> child = new ArrayList<>();

    public void addChildCategory(Category_08 category07){
        this.child.add(category07);
        category07.setParent(this);
    }

    public void addItem(Item_08 item){
        item08List.add(item);
    }
}
