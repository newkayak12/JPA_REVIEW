package inheritance.singleTableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
//작성하지 않으면 클래스 이름으로 자동 할당된다.
public class AlbumSingle extends Item07Single {
    private String artist;
}
