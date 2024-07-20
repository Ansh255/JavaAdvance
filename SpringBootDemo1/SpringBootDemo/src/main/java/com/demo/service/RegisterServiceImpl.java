
package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.RegisterDAO;
import com.demo.model.RegisterVO;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;

	@Override
	public void insert(RegisterVO registerVO) {
		this.registerDAO.insert(registerVO);
	}

}
