package inheritance.joinStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
// 엔티티를 저장할 때 구분 컬럼에 입력할 값을 지정한다.
public class AlbumJoined extends Item07Joined {
    private String artist;
}
