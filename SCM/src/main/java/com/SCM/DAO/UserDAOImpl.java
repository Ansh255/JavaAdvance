package com.SCM.DAO;

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

import com.SCM.model.*;


@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(userVO uservo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(uservo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<userVO> getElementByUserName(userVO uservo) {
		List<userVO> registerList = new ArrayList<userVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from uservo where email = "+uservo.getEmail());
			registerList = (List<userVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerList;
	}

	

}