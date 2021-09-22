package inheritance.joinStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class MovieJoined extends Item07Joined {
    private String director;
    private String actor;
}
