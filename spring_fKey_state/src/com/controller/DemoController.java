package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.FkeyDao;
import com.Dao.stateDao;
import com.VO.stateVo;
import com.VO.CountryVO;
import com.sun.research.ws.wadl.Request;


@Controller
public class DemoController {
	@Autowired
	private FkeyDao fkeydao;
	@Autowired
	private stateDao statedao;
	
	
	@RequestMapping(value = "addCountry.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		return new ModelAndView("addCountry","countryVO", new CountryVO());

	}
	@RequestMapping(value = "save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute CountryVO countryVO) {
		
		System.out.println("sdfghjm,./:::::::::::::::::::::::::::::::::::");
		
		fkeydao.insert(countryVO);
		
		return new ModelAndView("addCountry","countryVO", new CountryVO());

	}
	
}