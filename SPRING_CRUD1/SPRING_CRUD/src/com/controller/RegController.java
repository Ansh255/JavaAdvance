package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.model.RegVO;

@Controller
public class RegController {

	@Autowired
	private RegDAO regDAO;

	@RequestMapping(value = "load.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		return new ModelAndView("Registration",
				"RegVO", new RegVO());

	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView Insert(@ModelAttribute RegVO regVo) {

		regDAO.insert(regVo);
		return new ModelAndView("redirect:/search.html");

	}

	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView Search() {

		List searchList = regDAO.search();
		return new ModelAndView("Search", "SearchList", searchList);

	}

	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(HttpServletRequest request, @ModelAttribute RegVO regVO, @RequestParam int id) {

		regVO.setId(id);
		regDAO.delete(regVO);

		return new ModelAndView("redirect:/search.html");

	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView Edit(HttpServletRequest request, @ModelAttribute RegVO regVO, @RequestParam int id) {

		regVO.setId(id);
		List editList = regDAO.edit(regVO);

		return new ModelAndView("Registration", "RegVO", editList.get(0));

	}

}
