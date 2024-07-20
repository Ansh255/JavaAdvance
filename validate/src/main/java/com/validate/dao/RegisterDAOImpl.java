package com.validate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.validate.model.LoginVO;

@Transactional
@Repository

public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(LoginVO loginvo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(loginvo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}