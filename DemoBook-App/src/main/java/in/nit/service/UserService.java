package in.nit.service;



import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;

import in.nit.model.User;
import in.nit.util.HibernateUtil;

public class UserService {

	public static Integer saveUser(User user,HttpServletRequest req) throws Exception {
		SessionFactory sf=HibernateUtil.getSession();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		Integer id=0;
		try { 
		     Part part = req.getPart("photos");
		     InputStream inputStream = part.getInputStream();
			 byte[] bytes=new byte[inputStream.available()];
			 inputStream.read(bytes);
			 user.setPhoto(bytes);
		     id=(Integer) ses.save(user);
			tx.commit();

		} catch (Exception e) {
			System.out.println("exception in userService");
			tx.rollback();
			e.printStackTrace();
			throw new Exception();

		}
		return id;

	}
	
	public static User getUser(String pass) {
		Session session = HibernateUtil.getSession().openSession();
		User result=null;
		try {
		Query<User> query = session.createQuery("from User where  password=:password");
		query.setParameter("password", pass);
		
		
		result =  query.getSingleResult();
		if(result==null) {
			System.out.println("result in not there");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}	
