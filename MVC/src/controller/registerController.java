package controller;

import java.io.IOException;
import vo.RegisterVo;
import dao.RegisterDao;
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String s = request.getParameter("registerfn");
		String s1 = request.getParameter("registerln");
		
		RegisterVo v = new RegisterVo();
		v.setFn(s);
		v.setLn(s1);
		
		RegisterDao d = new RegisterDao();
		d.inst(v);
		response.sendRedirect("Register.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		RegisterVo v = new RegisterVo();
		RegisterDao dao = new RegisterDao();
		List ls = dao.search_ta();
		System.out.println(ls.size());
		HttpSession s1=request.getSession();
		s1.setAttribute("list", ls);
		response.sendRedirect("display.jsp");
	}

}
