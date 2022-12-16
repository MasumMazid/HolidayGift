package com.cognixia.jump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long  purchase_id;

	@Column(columnDefinition="VARCHAR(45)")
	private int UserId;
	
	@Column(columnDefinition="VARCHAR(45)")
	private int product_id;
	
	@Column(columnDefinition="VARCHAR(45)")
	private int quantity;

	public Purchase() {
		
	}

	public Purchase(long purchase_id, int user_id, int product_id, int quantity) {
		super();
		this.purchase_id = purchase_id;
		this.UserId = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}


	public long getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(long purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return UserId;
	}

	public void setUser_id(int user_id) {
		this.UserId = user_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}

	
	
	

