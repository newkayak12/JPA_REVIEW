package inheritance.singleTableStrategy;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item07Single {

    @Id
    @GeneratedValue
    @Column(name = "ITEMSINGLE_ID")
    private Long id;

    private String name;

    private int price;

}
