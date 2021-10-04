package com.jpa.jpa.domain.discriminatedValue.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.jpa.jpa.domain.Item;

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
