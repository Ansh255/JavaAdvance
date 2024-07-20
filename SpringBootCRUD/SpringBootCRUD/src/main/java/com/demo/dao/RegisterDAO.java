package com.demo.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.DTO.RegDTO;
import com.demo.model.LoginVO;
import com.demo.model.RegVO;
import com.demo.model.RegisterVO;

public interface RegisterDAO {

	void insert(RegisterVO registerVO);

	List<RegVO> search();

	List<RegisterVO> findById(int id);

	void saveL(LoginVO loginVO);

	void saveR(RegVO regVO);
	
	List<RegVO> findByIdDelete(int id);

	
	
}
