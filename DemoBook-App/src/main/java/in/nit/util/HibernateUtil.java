package in.nit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory ses=null;
	
	static {
		ses=new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSession() {
		return ses;
	}
}
