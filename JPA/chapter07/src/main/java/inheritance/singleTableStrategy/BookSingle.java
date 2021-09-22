package inheritance.singleTableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class BookSingle extends Item07Single {
    private String author;
    private String isbn;
}
