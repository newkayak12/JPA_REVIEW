package com.jpa.chapter11_web.domain.discriminatedValue.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.jpa.chapter11_web.domain.Item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
	private String director;
	private String actor;

}
