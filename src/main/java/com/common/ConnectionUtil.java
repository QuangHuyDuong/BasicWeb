package com.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure();
		return config.buildSessionFactory();
	}
}
