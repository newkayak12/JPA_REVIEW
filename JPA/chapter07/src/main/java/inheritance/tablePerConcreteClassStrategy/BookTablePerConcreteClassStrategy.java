package inheritance.tablePerConcreteClassStrategy;

import javax.persistence.Entity;

@Entity
public class BookTablePerConcreteClassStrategy extends Item07TablePerConcreteClassStrategy{
    private String author;
    private String isbn;
}
