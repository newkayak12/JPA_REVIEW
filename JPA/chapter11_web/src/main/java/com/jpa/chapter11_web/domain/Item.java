package com.jpa.chapter11_web.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import com.jpa.chapter11_web.exception.NotEnoughStockException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public class Item {
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

	public void addStock(int quantity){
		this.stockQuantity += quantity;
	}
	public void removeStock(int quantity){
		int resetStock = this.stockQuantity-quantity;
		if(resetStock<0){
			try {
				throw new NotEnoughStockException("need More Stock");
			} catch (NotEnoughStockException e) {
				resetStock = 0;
			}
		}
		this.stockQuantity = resetStock;
	}
	
	
}
