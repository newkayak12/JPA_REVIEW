package com.jpa.chapter11_web.domain.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String city;
	private String street;
	private String zipcode;
}
