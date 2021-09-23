package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALBUM")
public class Album_07 extends Item_07{
    private String author;
    private String isbn;


}
