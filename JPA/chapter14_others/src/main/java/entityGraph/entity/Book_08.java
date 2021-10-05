package entityGraph.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book_08 extends Item_08 {
    private String artist;
    private String etc;

}
