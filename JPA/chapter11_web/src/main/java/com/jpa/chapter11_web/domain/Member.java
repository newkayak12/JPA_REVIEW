package com.jpa.chapter11_web.domain;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jpa.chapter11_web.domain.embedded.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;
	
	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();
	
}
