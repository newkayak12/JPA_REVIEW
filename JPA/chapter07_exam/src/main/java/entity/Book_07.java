package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book_07 extends Item_07{
    private String artist;
    private String etc;

}
