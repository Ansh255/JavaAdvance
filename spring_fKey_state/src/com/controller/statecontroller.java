package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.FkeyDao;
import com.Dao.stateDao;
import com.VO.CountryVO;
import com.VO.stateVo;

@Controller
public class statecontroller {
	@Autowired
	private FkeyDao fkeydao;
	@Autowired
	private stateDao statedao;

	@RequestMapping(value = "addState.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		List ls = this.fkeydao.search();

		return new ModelAndView("addState", "stateVO", new stateVo()).addObject("countryList", ls);

	}
	
	@RequestMapping(value="saveState.html",method = RequestMethod.POST)
	public ModelAndView saveState(@ModelAttribute stateVo statevo) {
	//		CountryVO countryvo = statevo.getCountryVO();
	//		
	//		int countryId = countryvo.getId();
	//		
	//		statevo.getCountryVO().setId(countryId);
	//		
			statedao.insert(statevo);
		
		
		System.out.println("saved state");
		
		return new ModelAndView("addState", "stateVO", new stateVo());
	}
}