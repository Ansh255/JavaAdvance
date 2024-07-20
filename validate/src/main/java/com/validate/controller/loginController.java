package com.validate.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.validate.dao.RegisterDAO;
import com.validate.model.LoginVO;

@Controller
public class loginController {
	@Autowired
	private RegisterDAO regDAO;

	@GetMapping(value = "/")
	public ModelAndView load() {
		return new ModelAndView("registration", "LoginVO", new LoginVO());
	}

	@PostMapping(value = "insert")
	public ModelAndView insert_form(@Valid @ModelAttribute LoginVO loginVO, BindingResult bindingResult ,Model model) {
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult);
			model.addAttribute("errors", bindingResult.getAllErrors());
			
			return new ModelAndView("redirect:/");
		}
		loginVO.setStatus(true);
		this.regDAO.insert(loginVO);
		return new ModelAndView("redirect:/");
	}
	

}
