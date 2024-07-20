package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import vo.FKeyVo;
import vo.Loginvo;
//import vo.regvo;

public class FkeyDao {
	public void insert(FKeyVo v) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
        session.save(v);
		
		transaction.commit();
		session.close();
	}
	public List search(){
		List searchList = new ArrayList<>();
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from FKeyVo");
		searchList = q.list();
		
		transaction.commit();
		session.close();
		
		return searchList;
	}
	public void delete(FKeyVo v){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		 session.delete(v);
		 
		 transaction.commit();
			session.close();	
	}
	
}
