package com.cognixia.jump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gift {	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long product_id;
	
@Column(columnDefinition="VARCHAR(45)")
private String Product_name;
	
@Column(columnDefinition="VARCHAR(45)")
private int product_price;


public long getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return Product_name;
}
public void setProduct_name(String product_name) {
	Product_name = product_name;
}
public int getProduct_price() {
	return product_price;
}
public void setProduct_price(int product_price) {
	this.product_price = product_price;
}
public Gift(int product_id, String product_name, int product_price) {
	super();
	this.product_id = product_id;
	Product_name = product_name;
	this.product_price = product_price;
}

}
