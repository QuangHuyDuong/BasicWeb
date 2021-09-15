package com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.common.ConnectionUtil;
import com.modal.Customer;
import com.modal.Product;


public class AdminDao {
	public static void deleteProduct(String id) {
		
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Product p = session.get(Product.class, id);
		List<Customer> list = getAllCustomers();
		for (Customer customer : list) {
			CustomerDao.deleteProduct(customer, p);
		}
		session.delete(p);
		session.getTransaction().commit();
		session.close();
	}
	public static List<Customer> getAllCustomers(){
		List<Customer> list = null;
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String queryStr = "From Customer";
		
		Query query = session.createQuery(queryStr);
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	public static void updateProduct(Product p) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.get(Product.class, p.getId()).setName(p.getName());
		session.getTransaction().commit();
		session.close();
	}
	public static boolean addProduct(Product p) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		if(session.get(Product.class,p.getId()) !=null ) {
			return false;
		} else {
			session.save(new Product(p.getId(), p.getName()));
		}
		session.getTransaction().commit();
		session.close();
		
		
		return true;
	}
	public static void updateCustomer(Customer c) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.get(Customer.class, c.getUsername()).setPassword(c.getPassword());
		session.get(Customer.class, c.getUsername()).setIsAdmin(c.getIsAdmin());
		session.getTransaction().commit();
		session.close();
	}
	public static void main(String[] args) {
		System.out.println(getAllCustomers());
	}
}
