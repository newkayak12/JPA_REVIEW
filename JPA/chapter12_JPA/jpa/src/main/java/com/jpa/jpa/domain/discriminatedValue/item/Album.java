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
@DiscriminatorValue("A")
public class Album extends Item{
	private String artist;
	private String etc;
	
}
