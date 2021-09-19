package jpabook.start.chapter03_04;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
/*
    테이블과 매핑할 클래스는 @Entity를 필수로 붙여야한다. JPA가 관리하는 것으로 선언한다.(Autowired나.. Controller류, Repository, Service 등과 같은 개념인것 같다.)
    1. 기본 생성자는 필수(파라미터가 없는 public 또는 protected 생성자)
    2. final 클래스, enum, interface, inner 클래스에는 사용할 수 없다. >> abstract class는 가능한가보네?
    3. 저장할 필드에 final 사용할 수 없다.

    JPA가 엔티티 객체를 생성할 떄 기본 생성자를 사용하고 setter로 주입하는 방식을 사용하나보다. 기본 생성자가 반드시 필요하다고 하니

    속성 : name (JPA에서 사용할 엔티티 이름 보통 설정을 안해놓으면 클래스 이름이 된다.)
 */
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames =  {"NAME", "AGE"})})
/*
    엔티티와 매핑할 테이블 이름을 지정한다.
    속성 : name > 매핑할 테이블 이름
          catalog > catalog 기능이 있는 데이터베이스에서 catalog를 매핑
          **catalog :   1. 시스템 카탈로그는 시스템 그 자체에 관련이 있는 다양한 객체에 관한 정보를 포함하는 시스템 데이터베이스이다.
                        2. 시스템 카탈로그 내의 각 테이블은 사용자를 포함하여 DBMS에서 지원하는 모든 데이터 객체에 대한 정의나 명세에 관한 정보를 유지 관리하는 시스템 테이블이다.
                        3. 데이터 정의어의 결과로 구성되는 기본 테이블, 뷰, 인덱스, 패키지, 접근 권한 등의 데이터베이스 구조 및 통계 정보를 저장한다.
                        4. 카탈로그들이 생성되면 자료사전에 저장되기 떄문에 좁은 의미로는 카탈로그를 자료 사전이라고도 한다.
                        5. 카탈로그에 저장된 정보를 메타 데이터라고 한다.
          schema  > schema 기능이 있는 데이터베이스에서 schema를 매핑
          uniqueConstraint : DDL 생성 시에 유니크 제약조거을 만든다. 2개 이상의 복잡한 유니크 제약조건도 가능하다. (자동 생성으로 DDL을 정의할 때 사용)
 */


public class Member {
/*
    primary key mapping strategy
    1. 직접 할당
    2. 자동 할당
            - identity : 기본키 생성을 데이터 베이스에 위임함
            - sequence : 데이터베이스 시퀀스를 사용해서 할당
            - table : 키 생성 테이블을 사용

 */
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username", nullable = false, length = 10)
    private String userName;

    private Integer age;

    @Enumerated
//    자바의 Enum을 사용하려면 Enumerated로 매핑해야한다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
    /*
     @Column : 컬럼을 매핑
        - name : 테이블 컬럼 이름 : 객체 필드의 이름
        - insertable : 엔티티 저장 시 해당 필드도 같이 저장 false로 지정하면 DB에 저장하지 않는다. : true
        - updatable : 엔티티 수정 시 해당 필드도 같이 수정 false로 지정하면 DB 수정하지 않음 : true
        - table : 하나의 엔티티를 두 개 이상의 테이블에 매핑할 때 사용 : 현재 클래스가 매핑된 테이블
        - nullable(DDL) : null의 허용 여부 false일 경우 NN : true
        - unique(DDL) : @Table의 Constraints와 같지만 한 컬럼에 간단히 유니크를 걸 때 사용
        - columnDefinition(DDL) : 데이터 베이스 컬럼 정보를 직접 줄 수 있다. : 필드의 자바 타입과 방언 정보를 사용해서 적절한 컬럼 타입을 생성
        - length(DDL) : 문자 길이 제약조건, String 타입에만 사용 : 255
        - precision, scale(DDL) : BigDecimal에서 사용 precision은 소수점 포함 자릿수, scale은 소수의 자릿수(double, float에는 안됨) : precision = 19, scale =2


        (생략 시 @Column을 자동으로 붙이는데 자바 타입에 따라 DB에서 생성되는 것이 달라진다.
        1. 원시 타입인 경우 >> NN이 붙는다. (ex int data1 >> Integer data1 NN)
        2. 객체 타입인 경우 >> NN이 안 붙는다. (ex Integer data1 >> Integer data1)
        3. '@Column'을 붙이면 (ex int data1 >> Integer data1 )



     @Enumerated : 자바의 enum 타입을 매핑
        1. EnumType.ORDINAL : Enum의 순서를 DB에 저장
            >> member.setRoleType(RoleType.ADMIN) >> DB에 순서 '0'이 저장됨 ::: 저장 용량은 작되, Enum의 순서가 변경되면 문제가 생김
        2. EnumType.STRING : enum의 이름을 DB에 저장
            >> member.setRoleType(RoleType.ADMIN) >> DB에 ADMIN이 저장됨  ::: Enum 수정과 상관 없지만 문자열로 저장되어 용량이 큼

     @Temporal : 날짜 타입을 매핑
        1. TemporalType.DATE : 날짜, 데이터베이스 date타입과 매핑
        2. TemporalType.TIME : 시간, 데이터베이스 time타입과 매핑
        3. TemporalType.TIMESTAMP : 날짜와 시간, 데이터베이스 timestamp 타입과 매핑
        4. 생략 시에는 자바 Date와 가장 유사한 TimeStamp가 자동으로 매핑됨

     @Lob : Blob, Clob을 매핑
        문자: CLOB, 나머지:BLOB
            CLOB : String, char[], java.sql.CLOB
            BLOB : byte[], java.sql.BLOB

     @Transient : 특정 필드를 데이터베이스에 매핑하지 않음
         DB에 저장하지도 조회하지도 않는다. 객체에 임시로 어떤 값을 보관하고 싶을 때 사용한다.

     @Access : JPA가 엔티티에 접근하는 방식을 지정
        JPA가 ENTITTY에 접근하는 방식을 지정한다.
            1. 필드 접근 : AccessType.FIELD >> 필드 접근 권한이 private라도 접근할 수 있다.
            2. 프로퍼티 접근 : AccessType.PROPERTY >> GETTER를 사용해서 접근한다.
            @Access를 명시하지 않으면 @Id의 위치를 기준으로 접근 방식이 달라진다

            FIELD
            >>>
            public class Member {
                @Id
                private String id;

                ....

            }

            id가 필드에 있으므로 AccessType을 작성하지 않아도 필드 접근이 된다.
            <<<


            GETTER
            >>>
            public class Member{
                private String id;

                @Id
                public String getId(){
                    return id;
                }
            }

            id가 getter에 있으므로 Access를 명시하지 않아도 프로퍼티 접근이 된다.
            <<<

            FIELD+GETTER
            >>>
            public class Member {
                @Id
                private String id;

                @Transient
                private String firstName;

                @Transient
                private String lastName;


                @Access(AccessType.PROPERTY)
                public String getFullName(){
                    return firstName + lastName;
                }
            }
            <<<
     */

    /*
    field-based access
        If you use field-based access, your JPA implementation uses reflection to read or write your entity attributes directly. It also expects that you place your mapping annotations on your entity attributes.
        field 접근방식의 경우는 JPA 구현은 reflection 을 사용하여 Entity attributes directly 하게 읽고, 쓰고 할 수 있다. 이는 엔티티 속성에 @Access(Field) 애노테이션을 작성할 것을 기대합니다.


    property-based access
        If you use property-based access, you need to annotate the getter methods of your entity attributes with the required mapping annotations. Your JPA implementation then calls the getter and setter methods to access your entity attributes.
        property 접근방식을 사용하는 경우 필요한 매핑 주석으로 엔티티 속성의 getter 메서드에 주석을 추가해야합니다. 그런 다음 JPA 구현은 getter및 setter 메소드를 호출하여 엔티티 속성에 액세스합니다.

     */

}

