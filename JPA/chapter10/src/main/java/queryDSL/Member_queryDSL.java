package queryDSL;


import javax.persistence.*;


@Entity(name = "MEMBER_QUERYDSL")
@NamedStoredProcedureQuery(
        name = "multiple",
        procedureName = "proc_multiple",
        parameters = {
                @StoredProcedureParameter(name = "inParam", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "outParam", mode = ParameterMode.OUT, type = Integer.class)
        }

)
//이와 같이 저장된 프로시저를 이름으로 정의해서 불러낼 수 있다.
//여러 개의 프로시저를 정의하려면 @NamedStoredProcedureQueries를 이용하면 된다.
/*
    <?xml version = "1.0" encoding="UTF-8?>
    <entity-mappings xmlns="http://xmlns.jcp.org/xml/ns/persistence/orm" version="2.1">
        <named-stored-procedure-query name ="" procedure-name="">
            <parameter name="" mode="" class=""/>
            <parameter name="" mode="" class=""/>
        </named-stored-procedure-query>
    </entity-mappings>
    와 같이 xml방식으로도 사용할 수 있다.
 */
public class Member_queryDSL {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_QUERYDSL_ID")
    private Long id;

    @Column(name = "MEMBER_QUERYDSL_NAME")
    private String name;

    @Column(name = "MEMBER_QUERYDSL_ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Member_queryDSL(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public Member_queryDSL() {
    }
}
