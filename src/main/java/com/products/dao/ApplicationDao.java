package com.products.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.products.Bean.Product;
import com.products.Utilities.SessionCreater;

public class ApplicationDao {
	public List<Product> searchProducts(String searchString) {

		Product product = null;
		List<Product> products = new ArrayList<>();
		Session session = SessionCreater.getSession();
		session.beginTransaction();
		
		String sql = "select * from products where product_name like '%" + searchString + "%'";
		
		products = (List<Product>) session.createNativeQuery(sql);
		return products;
	}

}
