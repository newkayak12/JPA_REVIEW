package com.jpa.chapter11_web.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM" , joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private List<Item> items = new ArrayList<>();
	
	// parent
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	// child

	public void addChildCategory(Category child){
		this.child.add(child);
		child.setParent(this);
	}
}
