package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import vo.FKeyVo;
//import vo.regvo;
import vo.stateVo;

public class stateDao {
	public void insert(stateVo v) {
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
		
		Query q = session.createQuery("from stateVo");
		searchList = q.list();
		
		transaction.commit();
		session.close();
		
		return searchList;
	}
	public void delete(stateVo v){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		 session.delete(v);
		 
		 transaction.commit();
			session.close();	
	}
}
