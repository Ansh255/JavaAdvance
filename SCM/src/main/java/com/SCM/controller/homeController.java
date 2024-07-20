package com.SCM.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SCM.DAO.UserDAO;
import com.SCM.model.ContactVO;
import com.SCM.model.userVO;



@Controller
public class homeController {
	
	@Autowired
	private  BCryptPasswordEncoder passwordencoder;
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping(value = "/")
	public ModelAndView h() {
		return new ModelAndView("home");
	}
	
	@GetMapping(value = "/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@GetMapping(value = "/base")
	public ModelAndView base() {
		return new ModelAndView("base");
	}
	
	@GetMapping(value="/signup")
	public ModelAndView signup(){
		return new ModelAndView("signup" ,"userVO" , new userVO());
	}
	
	@PostMapping(value="/register")
	public ModelAndView insert(@Valid @ModelAttribute userVO uservo ,BindingResult result){
		 if (result.hasErrors()) {
	            return new ModelAndView("signup");
	        }
		 uservo.setPassword(passwordencoder.encode(uservo.getPassword()));
		 uservo.setRole("USER");
		 uservo.setEnabled(true);
		this.userDAO.insert(uservo);
		
		return new ModelAndView("home");
		
	}
}
