package queryDSL;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@ToString
@QueryEntity
@Entity(name = "MEMBER_QUERYDSL")
public class Member_queryDSL {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_QUERYDSL_ID")
    private Long id;

    @Column(name = "MEMBER_QUERYDSL_NAME")
    private String name;
}
