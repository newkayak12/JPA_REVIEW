package compositeKey.embeddedIdExam;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class ParentEmbeddedId {
    @EmbeddedId
    private ParentEmbeddedIdId id;
    /*
        idClass와는 다르게 EmbeddedId를 적용한 식별자 크래스는 식별자 클래스에 기본 키를 직접 매핑한다.
        @EmbeddedId를 적용한 식별자 클래스는 다음 조건을 만족해야한다.
            1. @Embeddedable을 붙여줘야한다.
            2. Serializable 인터페이스를 구현해야한다.
            3. Equals, hascode를 구현해야한다.
            4. 기본 생성자가 있어야한다.
            5. 식별자 클래스는 public 이어야만 한다.
     */
    private String name;
}
