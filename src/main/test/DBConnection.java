
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.products.Bean.Product;
import com.products.Utilities.SessionCreater;
public class DBConnection {

public static void main(String[] args) {
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class).buildSessionFactory();
		
	Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			NativeQuery product = session.createNativeQuery("select * from product where product_name like %"+"water"+"%");
			System.out.println();
			session.getTransaction().commit();
			session.close();
			
			
		}
		catch(Exception e) {
			System.out.println("error "+e);
		}
		
	}
	
	
}
