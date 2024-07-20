package com.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.LoginVO;
import com.VO.RegVO;;
@Repository
public class LoginDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void insert(LoginVO loginvo) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(loginvo);
			transaction.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void delete(LoginVO loginvo) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(loginvo);
		transaction.commit();
		session.close();

	}
	public List search(int id) {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from LoginVO where id="+id);

		List ls = q.list();
		session.close();

		return ls;
	}
}
