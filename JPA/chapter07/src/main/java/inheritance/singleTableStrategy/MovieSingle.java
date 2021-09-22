package inheritance.singleTableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class MovieSingle extends Item07Single {
    private String director;
    private String actor;


}
