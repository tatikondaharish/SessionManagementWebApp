package com.products.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.products.Bean.Product;
import com.products.Bean.User;
import com.products.Utilities.SessionCreater;

public class ApplicationDao {
	public List<Product> searchProducts(String searchString) {

		List<Product> products = new ArrayList<>();
		Session session = SessionCreater.getSession();
		session.beginTransaction();

		String sql = "select * from products where product_name like '%" + searchString + "%'";

		products = (List<Product>) session.createNativeQuery(sql);

		session.getTransaction().commit();
		session.close();
		return products;
	}

	public boolean registerUser(User user) {
		Session session = SessionCreater.getSession();

		try {
			session.beginTransaction();

			session.save(user);

			session.getTransaction().commit();

			session.close();
			return true;

		} catch (Exception e) {
			session.close();
			return false;
		}

	}

}
