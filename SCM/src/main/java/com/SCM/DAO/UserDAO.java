package com.SCM.DAO;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.SCM.model.userVO;


public interface UserDAO {

	 void insert(userVO uservo) ;
		

	 List getElementByUserName(userVO uservo);	
	
	
}
