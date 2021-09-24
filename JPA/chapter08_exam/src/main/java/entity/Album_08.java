package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALBUM")
public class Album_08 extends Item_08 {
    private String author;
    private String isbn;


}
