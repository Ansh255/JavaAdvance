package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.RegVO;
import com.demo.model.RegisterVO;
import com.demo.service.RegisterService;

@Controller
public class RegisterController {

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

	@GetMapping(value = "search")
	public ModelAndView search() {
		List<RegVO> registerList = this.registerService.search();
		return new ModelAndView("search", "registerList", registerList);
	}

	@GetMapping(value = "delete")
	public ModelAndView delete(@ModelAttribute RegisterVO registerVO, @RequestParam int id) {

		List<RegisterVO> registerList = this.registerService.findById(id);

		registerVO = registerList.get(0);
		registerVO.setStatus(false);

		this.registerService.insert(registerVO);

		return new ModelAndView("redirect:/search");
	}

	@GetMapping(value = "edit")
	public ModelAndView edit(@ModelAttribute RegisterVO registerVO, @RequestParam int id) {

		List<RegisterVO> registerList = this.registerService.findById(id);

		registerVO = registerList.get(0);

		return new ModelAndView("registration", "RegisterVO", registerVO);
	}
}
