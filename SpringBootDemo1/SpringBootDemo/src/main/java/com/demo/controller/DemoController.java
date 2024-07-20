package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.RegisterVO;
import com.demo.service.RegisterService;

@Controller
public class DemoController {

	@Autowired
	private RegisterService registerService;

	@GetMapping(value = "/")
	public ModelAndView loadRegister() {
		return new ModelAndView("registration", "RegisterVO", new RegisterVO());
	}

	@PostMapping(value = "insert")
	public ModelAndView insert(@ModelAttribute RegisterVO registerVO) {
		this.registerService.insert(registerVO);
		return new ModelAndView("redirect:/");
	}
	
	
	
}

