package com.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.RegisterVO;

@RestController
public class apiController {
	@GetMapping(value="/user")
	public ResponseEntity getUser(){
		
		List<RegisterVO> registerList = this.registerService.search();
		
		return new ResponseEntity("ok",HttpStatus.OK);
	}
}
