package jpabook.start.chpater05.relationshipWithJpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;
}
