package com.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.DTO.RegDTO;
import com.demo.model.RegVO;
import com.demo.model.RegisterVO;

public interface RegisterService {

	void insert(RegisterVO regVO);

	List<RegVO> search();

	List<RegisterVO> findById(int id);
	
	ResponseEntity saveUser(RegDTO regdto);

	ResponseEntity viewUser();

	ResponseEntity delete(int id);

	ResponseEntity update(RegDTO regdto, int id);

	

	


	
	

}
	