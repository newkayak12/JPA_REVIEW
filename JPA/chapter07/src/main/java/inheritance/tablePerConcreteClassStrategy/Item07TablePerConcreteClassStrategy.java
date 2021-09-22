package inheritance.tablePerConcreteClassStrategy;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item07TablePerConcreteClassStrategy {

        @Id
        @GeneratedValue
        @Column(name = "ITEM07TABLEPERCONCRETECLASSSTRATEGY_ID")
        private Long id;
        private String name;
        private int price;

}
