package com.jpa.chapter11_web.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.jpa.chapter11_web.domain.embedded.Address;
import com.jpa.chapter11_web.domain.enumeration.DeliverStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Delivery {
	@Id
	@GeneratedValue
	@Column(name = "DELIVERY_ID")

	@OneToOne(mappedBy = "delivery")
	private Order order;

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING)
	private DeliverStatus status;
}
