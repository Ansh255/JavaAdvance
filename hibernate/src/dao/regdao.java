package dao;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.*;

import vo.regvo;

public class regdao {
	public void insert(regvo v){
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
		
		Query q = session.createQuery("from regvo");
		searchList = q.list();
		
		session.close();
		
		return searchList;
		
	}
	public void delete(regvo v){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		 session.delete(v);
		 
		 transaction.commit();
			session.close();	
	}
	public regvo edit(regvo v){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query q = session.createQuery("from regvo where id='"+v.getId()+"'");
		v =  (regvo) q.list().get(0);
//		here we make the query statement to list and .get(0) returns the object of vo at 0th index
//		v =  (regvo) q.list();
		System.out.println(q);
		System.out.println(v);
		transaction.commit();
		session.close();
		return v;
	}
	public void update(regvo v){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		 session.update(v);
		 
		 transaction.commit();
			session.close();	
	}
	
}
