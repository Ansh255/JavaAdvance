package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import vo.RegisterVo;

/**
 * Servlet implementation class multipledeleteController
 */
@WebServlet("/multipledeleteController")
public class multipledeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public multipledeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String[] s5=request.getParameterValues("box");
		int i=0;
		if(s5!=null && s5.length!=0)
		{
			for(i=0;i<s5.length;i++){
				System.out.println(i);
				int j = Integer.parseInt(s5[i]);
				RegisterVo v = new RegisterVo();
				RegisterDao d = new RegisterDao();
				v.setId(j);
				d.delete(v);
			
			}
			response.sendRedirect("searchController");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
