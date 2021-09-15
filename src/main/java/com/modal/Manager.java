package com.modal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.common.ConnectionUtil;

public class Manager {
	public static void main(String[] args) {
       Session session = ConnectionUtil.getSessionFactory().openSession();
       session.beginTransaction();
       
       session.save(new Product("P005", "San pham 5"));
       session.save(new Product("P006", "San pham 6"));
       session.save(new Product("P007", "San pham 7"));
       session.save(new Product("P008", "San pham 8"));
       session.save(new Product("P009", "San pham 9"));
       session.save(new Product("P010", "San pham 10"));
       session.save(new Product("P011", "San pham 11"));
       session.save(new Product("P012", "San pham 12"));
       session.save(new Product("P013", "San pham 13"));
       session.save(new Product("P014", "San pham 14"));
       session.save(new Product("P015", "San pham 15"));
       session.save(new Product("P016", "San pham 16"));
       session.getTransaction().commit();
       session.close();
	}
	
}
