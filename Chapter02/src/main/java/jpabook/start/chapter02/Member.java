package jpabook.start.chapter02;

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
