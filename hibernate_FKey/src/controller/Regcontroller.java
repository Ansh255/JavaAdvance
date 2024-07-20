package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Logindao;
import dao.Regdao;
//import dao.regdao;
import vo.Loginvo;
import vo.Regvo;


/**
 * Servlet implementation class regcontroller
 */
@WebServlet("/Regcontroller")
public class Regcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Regcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		if(flag.equals("search")){
			search(request, response);
			response.sendRedirect("display.jsp");
		}
		else if(flag.equals("delete")){
			delete(request,response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if (flag.equals("insert")) {
			insert(request, response);
			response.sendRedirect("register.jsp");

		}

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fn = request.getParameter("registerfn");
		String ln = request.getParameter("registerln");
		String un = request.getParameter("registerun");
		String ps = request.getParameter("registerps");

		Loginvo v = new Loginvo();
		v.setUsername(un);
		v.setPassword(ps);

		Logindao d = new Logindao();
		d.insert(v);

		Regvo v1 = new Regvo();
		v1.setFirstname(fn);
		v1.setLastname(ln);
		v1.setLoginvo(v);

		Regdao d1 = new Regdao();
		d1.regInsert(v1);
	}
	protected void search(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Regvo r = new Regvo();
		Regdao d = new Regdao();
		

		List ls = d.search();
		System.out.println(ls.size());

		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		Regdao d = new Regdao();
		Regvo v = new Regvo();
		Loginvo v1 =new Loginvo();
		Logindao d1 = new Logindao();
		
		
		
		d.deleteR(v);
		
	}

}
