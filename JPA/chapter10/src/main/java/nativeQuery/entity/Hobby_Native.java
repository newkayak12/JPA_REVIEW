package nativeQuery.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SqlResultSetMapping(name = "HobbyWithMember",
entities = {@EntityResult(entityClass = Member_Native.class, fields = {
        @FieldResult(name = "id", column = "MEMBER_NATIVE_ID"),
        @FieldResult(name = "NAME", column = "NAME"),
        /*
            이와 같이 엔티티도 컬럼명이 겹칠 경우 세부적으로 매핑할 수 있다.
         */
})},
columns = {@ColumnResult(name = "HOW_LONG"), @ColumnResult(name = "HOBBY")}
)
//미리 결과 매핑을 정의하여 사용할 수 있다.

/*
    @SqlResultSetMapping
        - name : 결과 이름 매핑
        - entities : @EntitiyResult를 사용해서 엔티티를 결과로 매핑한다.
        - columns : @ColumnResult를 사용해서 컬럼을 결과로 매핑한다.
    @EntityResult
        - entityClass : 결과로 사용할 엔티티 클래스를 지정한다.
        - fields : @FieldResult을 사용해서 결과 컬럼을 필드와 매핑한다.
        - discriminatorColumn : 엔티티의 인스턴스 타입을 구분하는 필드(상속에서 사용)
    @FieldResult
        - name : 결과를 받을 필드명
        - column : 결과 컬럼명
    @ColumnResult
        - name : 결과 컬럼명
 */
@NamedNativeQuery(
        name = "Hobby_selectQuery",
        query = "select h.hobby, h.how_long, m.* from HOBBY_NATIVE h join NATIVE_MEMBER m on h.MEMBER_NATIVE_ID = m.MEMBER_NATIVE_ID",
        resultSetMapping = "HobbyWithMember"

)
/*
    @NamedNativeQuery
        - name : 네임드 쿼리 이름(필수)
        - query : SQL 쿼리 (필수)
        - hints : 벤더 종속적인 힌트
        - resultClass : 결과 클래스
        - resultMapping : 결과 매핑 사용
 */
public class Hobby_Native {
    @Id
    @GeneratedValue
    @Column(name = "HOBBY_NATIVE_ID")
    private Long id;

    private int howLong;
    private String hobby;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NATIVE_ID")
    private Member_Native member;

    public void addMember(Member_Native member){
        if(this.member!=null){
            this.member.getHobby().remove(this);
        }
        this.member = member;
        member.getHobby().add(this);
    }

    @Override
    public String toString() {
        return "Hobby_Native{" +
                "howLong=" + howLong +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
