package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.common.ConnectionUtil;
import com.modal.Customer;
import com.modal.Product;

public class ProductDao {

	public static List<Product> viewByIndex(int index){
		Session session = ConnectionUtil.getSessionFactory().openSession();
		String queryStr = "From Product Order by ID";
		Query query =session.createQuery(queryStr);
		query.setFirstResult((index-1) *9);
		query.setMaxResults(9);
		List<Product> list = query.list();
		session.close();
		return list;
	}
	public static int countProduct() {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		String queryStr = "From Product";
		Query query =session.createQuery(queryStr);
		ArrayList<Product> list = (ArrayList<Product>) query.list();
		if(list.size() % 9 == 0) return (list.size()/9);
		else return (list.size()/9 + 1);
	}
	
	
	
}
