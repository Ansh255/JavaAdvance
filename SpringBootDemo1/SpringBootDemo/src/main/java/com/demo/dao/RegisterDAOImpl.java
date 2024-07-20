
package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.demo.model.RegisterVO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(RegisterVO registerVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(registerVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	