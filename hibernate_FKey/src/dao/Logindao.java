package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import vo.Loginvo;
import vo.Regvo;

public class Logindao {

	public void insert(Loginvo v) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
        session.save(v);
		
		transaction.commit();
		session.close();
	}
	public void deleteL(Loginvo v){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		 session.delete(v);
		 
		 transaction.commit();
			session.close();	
	}

}
