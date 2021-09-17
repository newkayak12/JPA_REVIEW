package jpabook.start;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Member {
private String id;
private String userName;
private Integer age;



}
