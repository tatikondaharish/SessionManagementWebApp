package com.products.Utilities;

import org.hibernate.SessionFactory;



import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.products.Bean.Product;
import com.products.Bean.User;


public class SessionCreater {

	static SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Product.class)
			.addAnnotatedClass(User.class).buildSessionFactory();
	static ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
	
	public static void buildSession() {
		ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
		sessionThread.set(sessionFactory.openSession());
		
	}
	
	public static Session getSession() {
		System.out.println("Session Thread : "+sessionThread);
		if (null == sessionThread.get()) {
			System.out.println("Session is null. Forming one.");
			Session session = sessionFactory.openSession();
			sessionThread.set(session);
		}
		return sessionThread.get();
		
	}

	public static void removeSession() {
		sessionThread.remove();
	}
}