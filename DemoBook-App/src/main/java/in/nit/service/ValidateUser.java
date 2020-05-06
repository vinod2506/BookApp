package in.nit.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import in.nit.model.User;
import in.nit.util.HibernateUtil;

public class ValidateUser {

	
	public static boolean validateUser(String user,String pass) {
		SessionFactory sf=HibernateUtil.getSession();
		Session session = sf.openSession();
		Query<User> query = session.createQuery("from User where userName=:username and password=:password");
		query.setParameter("username", user);
		query.setParameter("password", pass);
		
		List<User> list = query.getResultList();
		System.out.println("User data : "+list);
		if(list.size()==0)
			return false;
		else
			return true;
	     
	
	
	}
}
