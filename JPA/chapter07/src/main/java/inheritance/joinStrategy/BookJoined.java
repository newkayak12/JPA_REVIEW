package inheritance.joinStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
// BOOK 테이블의 기본키 컬럼명을 BOOK_ID로 변경했다.
public class BookJoined extends Item07Joined {
    private String author;
    private String isbn;
}
