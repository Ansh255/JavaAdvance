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

import com.Dao.RegDAO;
import com.VO.RegVO;
import com.sun.research.ws.wadl.Request;


@Controller
public class DemoController {
	@Autowired
	private RegDAO regDAO;
	
	@RequestMapping(value="hello.html", method = RequestMethod.GET)
	public ModelAndView load()
	{
		String s = "This is Spring Example...";
		return new ModelAndView("Demo","msg",s); 
		
//		(jsp page , key ,value)
//		modal -- vo ,, view -- jsp
		
	}
	
	
	@RequestMapping(value="reg.html", method = RequestMethod.GET)
	public ModelAndView registerFLOW()
	{
		return new ModelAndView("reg");
	}
	
	
	@RequestMapping(value="display.html", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request)
	{
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		return new ModelAndView("display","names",fn+" "+ln);
	}
	
	
	
	@RequestMapping(value="register.html", method = RequestMethod.GET)
	public ModelAndView Travel()
	{
		
		return new ModelAndView("register_new");
	}
	
	
	
	@RequestMapping(value="save.html", method = RequestMethod.POST)
	public ModelAndView registerNew(HttpServletRequest request)
	{
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String un = request.getParameter("userName");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("firstname", fn);
		session.setAttribute("lastname", ln);
		session.setAttribute("username", un);
		session.setAttribute("password", pass);
		
		
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="verify.html", method = RequestMethod.POST)
	public ModelAndView Traveltwo(HttpServletRequest request)
	{
		String un = request.getParameter("un");
		String pass = request.getParameter("pd");
		
		HttpSession session = request.getSession();
		
		String s = (String) session.getAttribute("username");
		String s1 = (String)session.getAttribute("password");
		String fn= (String) session.getAttribute("firstname");
		String ln = (String)session.getAttribute("lastname");
		
		
		
		if(un.equals(s) && pass.equals(s1)){
			
		return new ModelAndView("welcome","value",fn+"\n"+ln);
	}
		else{
			return new ModelAndView("login");
		}

}
	@RequestMapping(value="modelattribute.html", method= RequestMethod.GET)
	public ModelAndView load_two(){
		return new ModelAndView("open","data",new RegVO());
	}
	
	
	
//	@RequestMapping(value="saveAdd.html", method= RequestMethod.POST)
//	public ModelAndView one(@ModelAttribute RegVO v){
//		System.out.println(v.getFn());
//		System.out.println(v.getLn());
//		return new ModelAndView("displ","data",v); 
//	}
	
	@RequestMapping(value = "load.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		return new ModelAndView("register_new",
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
		return new ModelAndView("search", "SearchList", searchList);

	}
	
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(@ModelAttribute RegVO regVO, @RequestParam int id) {

		regVO.setId(id);
		regDAO.delete(regVO);

		return new ModelAndView("redirect:/search.html");

	}
	@RequestMapping(value="edit.html",method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegVO regVO, @RequestParam int id){
		regVO.setId(id);
	
		List ls  = regDAO.edit(regVO);
		return new ModelAndView("register_new","RegVO",ls.get(0));
		
	}
	@RequestMapping(value = "multipledel.html", method = RequestMethod.POST)
	public ModelAndView MultipleDelete(@ModelAttribute RegVO regVO,HttpServletRequest request) {
		String[] s5 = request.getParameterValues("box");
		int i = 0;
		int j = 0;
		if (s5 != null && s5.length != 0) {
			for (i = 0; i < s5.length; i++) {
				System.out.println(i);
				 j = Integer.parseInt(s5[i]);
				regVO.setId(j);
				regDAO.delete(regVO);
			}
		}
		return new ModelAndView("redirect:/search.html");
	}
	
}
