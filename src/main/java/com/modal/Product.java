package com.modal;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	private String id;
	private String name;
	private String img;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products",cascade = CascadeType.ALL)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaJHHovVO36rCgZDgAad5hchXWr1ZSil8bfw&usqp=CAU";
	}
	
	public Product(String id) {
		super();
		this.id = id;
		this.img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaJHHovVO36rCgZDgAad5hchXWr1ZSil8bfw&usqp=CAU";
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(! (obj instanceof Product)) return false;
		else {
			Product obje = (Product) obj;
			if(this.id.equals(obje.id)) return true;
			else return false;
		}
		
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", img=" + img + "]";
	}
	
	
	
	
}
