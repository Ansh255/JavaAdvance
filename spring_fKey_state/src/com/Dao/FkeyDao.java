package com.Dao;
import java.util.ArrayList;
//import vo.regvo;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.CountryVO;

@Repository
public class FkeyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void insert(CountryVO countryVO) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
        session.save(countryVO);
		
		transaction.commit();
		session.close();
	}
	public List search(){
		List searchList = new ArrayList<>();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from CountryVO");
		searchList = q.list();
		
		transaction.commit();
		session.close();
		
		return searchList;
	}	
}
