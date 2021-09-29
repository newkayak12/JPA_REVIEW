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
@DiscriminatorValue("B")
public class Book extends Item{
	private String author;
	private String isbn;
	
}
