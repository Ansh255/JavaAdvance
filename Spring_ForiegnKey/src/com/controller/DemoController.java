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

import com.Dao.LoginDAO;
import com.Dao.RegDAO;
import com.VO.LoginVO;
import com.VO.RegVO;
import com.sun.research.ws.wadl.Request;


@Controller
public class DemoController {
	@Autowired
	private RegDAO regDAO;
	@Autowired
	private LoginDAO logDAO;
	
	
	@RequestMapping(value = "loadform.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		return new ModelAndView("reg","RegVO", new RegVO());

	}
	@RequestMapping(value = "save.html", method = RequestMethod.POST)
	public ModelAndView Insert(@ModelAttribute RegVO regvo) {
		LoginVO loginvo = regvo.getLoginvo();
		
		logDAO.insert(loginvo);
		
		regDAO.insert(regvo);
		
		return new ModelAndView("redirect:/searchdata.html");
	}
	@RequestMapping(value = "searchdata.html", method = RequestMethod.GET)
	public ModelAndView Search() {
		
		List searchList = regDAO.searchM();
		return new ModelAndView("search", "SearchList", searchList);
	}
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(@RequestParam int regId) {
		List regvoList  = regDAO.search(regId);
		RegVO regvo = (RegVO) regvoList.get(0);
		
		int loginid  = regvo.getLoginvo().getId() ;
		
		List loginvolist = logDAO.search(loginid);
		
		LoginVO loginvo = (LoginVO) loginvolist.get(0);
		
		regDAO.delete(regvo);
		logDAO.delete(loginvo);
		
		return new ModelAndView("redirect:/searchdata.html");
	}
	@RequestMapping(value="edit.html",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int regId){
		List regvoList  = regDAO.search(regId);
		
		return new ModelAndView("reg","RegVO",regvoList.get(0));
	}

	
}
