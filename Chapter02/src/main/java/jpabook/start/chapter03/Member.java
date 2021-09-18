package jpabook.start.chapter03;

import lombok.*;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString

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


}

