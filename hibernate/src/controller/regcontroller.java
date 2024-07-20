package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.*;
import dao.regdao;

/**
 * implementation class
 */
@WebServlet("/regcontroller")
public class regcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public regcontroller() {
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
		if (flag.equals("search")) {
			search(request, response);
			response.sendRedirect("display.jsp");
		} else if (flag.equals("delete")) {
			delete(request, response);
			search(request, response);
			response.sendRedirect("display.jsp");
		} else if (flag.equals("edit")) {
			edit(request, response);
			response.sendRedirect("update.jsp");

		} else if (flag.equals("update")) {
			update(request, response);
			search(request, response);
			response.sendRedirect("display.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag = request.getParameter("flag");
		if (flag.equals("insert")) {
			insert(request, response);
			response.sendRedirect("register.jsp");
		} else if (flag.equals("multipledel")) {
			multipledelete(request, response);
			search(request, response);
			response.sendRedirect("display.jsp");

		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("registerfn");
		String s1 = request.getParameter("registerln");

		regvo r = new regvo();
		r.setFirstName(s);
		r.setLastName(s1);

		regdao d = new regdao();
		d.insert(r);
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		regvo r = new regvo();
		regdao d = new regdao();

		List ls = d.search();
		System.out.println(ls.size());

		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		regvo v = new regvo();
		v.setId(i);
		regdao dao = new regdao();

		dao.delete(v);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		regvo v = new regvo();
		v.setId(i);
		regdao dao = new regdao();
		regvo ls = dao.edit(v);
		System.out.println(ls);
		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		String s = request.getParameter("firstName");
		String s1 = request.getParameter("lastName");
		regvo v = new regvo();
		v.setId(i);
		v.setFirstName(s);
		v.setLastName(s1);
		regdao dao = new regdao();
		dao.update(v);
	}

	protected void multipledelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] s5 = request.getParameterValues("box");
		int i = 0;
		if (s5 != null && s5.length != 0) {
			for (i = 0; i < s5.length; i++) {
				System.out.println(i);
				int j = Integer.parseInt(s5[i]);
				regvo v = new regvo();
				regdao d = new regdao();
				v.setId(j);
				d.delete(v);

			}
		}

	}
}
