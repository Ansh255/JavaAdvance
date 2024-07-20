package com.demo.util;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.demo.DTO.RegDTO;
import com.demo.DTO.Response;

@Component
public class BaseMethods {
	
	public Response validateUserRequest(RegDTO regdto){
		Response response = new Response();
		response.setStatus(true);
		
		if (regdto.getFn() == null || regdto.getFn().isEmpty()) {
			response.setStatus(false);
			response.setMassage("FirstName is required");
		
		} else if (regdto.getLn() == null || regdto.getLn().isEmpty()) {
			response.setStatus(false);
			response.setMassage("LastName is required");
			
		} else if (regdto.getUn() == null || regdto.getUn().isEmpty()) {
			response.setStatus(false);
			response.setMassage("UserName is required");
			
		} else if (regdto.getPs() == null || regdto.getPs().isEmpty()) {
			response.setStatus(false);
			response.setMassage("PassWord is required");
			
	}
		return response;
}
}
