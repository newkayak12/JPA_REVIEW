package polymorphism;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("BOOK")
public class Book_Polymorphism extends Item_Polymorphism{
    private String author;
    private String isbn;
}
