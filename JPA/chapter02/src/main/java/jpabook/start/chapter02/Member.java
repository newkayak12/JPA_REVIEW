package jpabook.start.chapter02;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
private String id;
private String userName;
private Integer age;



}
