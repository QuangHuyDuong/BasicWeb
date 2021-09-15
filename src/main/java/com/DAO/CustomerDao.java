package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.common.ConnectionUtil;
import com.modal.Customer;
import com.modal.Product;

public class CustomerDao {
	public static Customer logIn(String username, String password) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		Customer cus = session.get(Customer.class, username);
		session.close();
		if(cus == null) return null;
		else if(cus.getPassword().equals(password)) return cus;
		else return null;
	}
	public static void addToCart(String id_product, String username) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.get(Customer.class, username).getProducts().add(session.get(Product.class,id_product));
		session.getTransaction().commit();
		session.close();
	}
	public static List<Product> viewCart(Customer c) {
		List<Product> list = null;
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.get(Customer.class, c.getUsername()).getProducts();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	public static void deleteProduct(Customer c , Product p) {
		
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.get(Customer.class, c.getUsername()).getProducts().remove(p);
		session.getTransaction().commit();
		session.close();
		
	}
	public static void signUp(Customer c){
		c.setIsAdmin(0);
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}
	
	
}
