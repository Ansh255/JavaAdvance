package com.Dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.*;

@Repository
public class stateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(stateVo v) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		System.out.println(v.getStateName());
		System.out.println(v.getId());
		System.out.println(v.getCountryVO());
        session.save(v);
		
		transaction.commit();
		session.close();
	}
	public List search(){
		List searchList = new ArrayList<>();
	
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from stateVo");
		searchList = q.list();
		
		transaction.commit();
		session.close();
		
		return searchList;
	}
	
}
