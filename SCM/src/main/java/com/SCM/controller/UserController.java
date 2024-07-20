package com.SCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("/index")
	public ModelAndView loaduser(){
		return new ModelAndView("user/userhome");
	}
}
