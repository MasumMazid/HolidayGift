package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;




@Entity
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum Role{
		ROLE_USER, ROLE_CUSTOMER, ROLE_ADMIN,
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long  id;
	
	@NotBlank
	@Column(name="username",nullable=false)
	private String username;
	
	@NotBlank
	@Column(columnDefinition="VARCHAR(45)", nullable = false)
	private String password;
	
	
	@Column(columnDefinition="VARCHAR(45)", nullable = false)
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(columnDefinition="VARCHAR(45)")
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer() {
		this(1l,"n/a","n/a","n/a","n/a");
	}
	public Customer(long id, String username, String password, String email, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}






}
