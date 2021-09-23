package compositeKey.idClassExam;

import javax.persistence.*;

@Entity
public class ChildIdClass {
    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENTNONIDENTIFYING_ID1", referencedColumnName = "PARENTNONIDENTIFYING_ID1"),
            @JoinColumn(name = "PARENTNONIDENTIFYING_ID2", referencedColumnName = "PARENTNONIDENTIFYING_ID2")
    })
    private ParentIdClass parentNonIdentifying;

    /*
        복합키이므로 @JoinColumns에 에 각각 외래키로 @JoinColum을 넣어서 복합키를 매핑한다.
        @JoinColumn의 name과 referencedColumnName이 같으면 referencedColumnName을 생략해도 된다.
     */
}
