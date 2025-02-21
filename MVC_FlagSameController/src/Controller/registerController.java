package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.registerVO;
import DAO.registerDAO;

/**
 * Servlet implementation class RegisterController
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String flag = request.getParameter("flag");
		System.out.println(flag);
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
		} else if (flag.equals("multipledel")) {
			multipledelete(request, response);
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
		String s = request.getParameter("registerfn");
		String s1 = request.getParameter("registerln");

		registerVO v = new registerVO();
		v.setFn(s);
		v.setLn(s1);

		registerDAO d = new registerDAO();
		d.inst(v);
		response.sendRedirect("Register.jsp");
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("registerfn");
		registerVO v = new registerVO();
		v.setFn(s);
		registerDAO dao = new registerDAO();
		List ls = dao.search_ta();
		System.out.println(ls.size());
		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		registerVO v = new registerVO();
		v.setId(i);
		registerDAO dao = new registerDAO();
		dao.delete(v);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		registerVO v = new registerVO();
		v.setId(i);
		registerDAO dao = new registerDAO();
		List ls = dao.search_edit(v);
		System.out.println(ls.size());
		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		String s = request.getParameter("firstName");
		String s1 = request.getParameter("lastName");
		registerVO v = new registerVO();
		v.setId(i);
		v.setFn(s);
		v.setLn(s1);
		registerDAO dao = new registerDAO();
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
				registerVO v = new registerVO();
				registerDAO d = new registerDAO();
				v.setId(j);
				d.delete(v);

			}
		}

	}

}
