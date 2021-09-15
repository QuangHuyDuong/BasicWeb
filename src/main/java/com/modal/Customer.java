package com.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	private String username;
	private String password;
	private int isAdmin;
	@ManyToMany(fetch = FetchType.EAGER)
    private	List<Product> products;
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
	public List<Product> getProducts() {
		return products;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = 0;
		this.products = new ArrayList<Product>();
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + ", products="
				+ products + "]";
	}
	
	
}
