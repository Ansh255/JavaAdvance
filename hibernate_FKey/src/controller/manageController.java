package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FkeyDao;
import dao.Logindao;
import dao.Regdao;
import dao.regdao;
import vo.FKeyVo;
import vo.Loginvo;
import vo.Regvo;
import vo.regvo;

/**
 * Servlet implementation class manageController
 */
@WebServlet("/manageController")
public class manageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag  = request.getParameter("flag");
		
		if(flag.equals("load")){
			search(request,response);
			response.sendRedirect("display.jsp");
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		FKeyVo v = new FKeyVo();
		FkeyDao d = new FkeyDao();
		

		List ls = d.search();
		System.out.println(ls.size());

		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);
		
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		String ps = request.getParameter("addc");
		FkeyDao d = new FkeyDao();
		FKeyVo v =new FKeyVo();
		v.setCountry(ps);
		d.insert(v);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag  = request.getParameter("flag");
		if(flag.equals("insert")){
			insert(request,response);
			
			
		}
	}

}
