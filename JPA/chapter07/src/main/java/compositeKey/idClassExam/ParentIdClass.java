package compositeKey.idClassExam;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@IdClass(ParentIdClassId.class)
/*
    @IdClass를 사용할 때 식별자 클래스는

        1. 식별자 클래스의 속성명과 엔티티에서 사용하는 식별자의 속성명이 같아야 한다.
        2. Serializable 인터페이스를 구현해야한다.
        3. equals, hashCode를 구현해야한다.
        4. 기본 생성자가 있어야한다.
        5. 식별자 클래스는 public이어야만 한다.
 */
public class ParentIdClass {
    @Id
    @Column(name = "PARENTNONIDENTIFYING_ID1")
    private String id1;

    @Id
    @Column(name = "PARENTNONIDENTIFYING_ID2")
    private String id2;

    private String name;

    public ParentIdClass(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}
