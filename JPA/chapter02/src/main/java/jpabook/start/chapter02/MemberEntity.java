package jpabook.start.chapter02;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
// 기본적으로 hibernate는 모든 컬럼은 update해서 일정한 수정 쿼리문을 만들어낸다.
//그러나 @DynamicUpdate를 사용하면 필요한 부분만 업데이트 한다. (컬럼이 많을 경우)
//자매품으로 데이터가 존재하는 필드만으로 INSERT를 하는 @DynamicInsert도 있다.
//@Table(name = "MEMBER")
//@Entity
public class MemberEntity {
    @Id
    @Column
    private String id;

    @Column(name="NAME")
    private String name;

    private Integer age;



}
