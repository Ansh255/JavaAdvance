package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
	
	@GetMapping("/one")
	public String welcome(){
		return "this is Example for security";
	}
}
