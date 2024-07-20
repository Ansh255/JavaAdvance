package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.demo.DTO.RegDTO;
import com.demo.model.LoginVO;
import com.demo.model.RegVO;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<RegVO> search() {
		List<RegVO> registerList = new ArrayList<RegVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from RegVO where status = true");
			registerList = (List<RegVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterVO> findById(int id) {
		List<RegisterVO> registerList = new ArrayList<RegisterVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from RegisterVO where status = true and id = " + id);
			registerList = (List<RegisterVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerList;
	}

	@Override
	public void saveL(LoginVO loginVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(loginVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveR(RegVO regVO) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(regVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RegVO> findByIdDelete(int id) {
		List<RegVO> registerList = new ArrayList<RegVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from RegVO where status = true and id = " + id);
			registerList = (List<RegVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerList;
	}


	
	}


