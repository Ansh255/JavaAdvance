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
//import dao.regdao;
import dao.stateDao;
import vo.FKeyVo;
//import vo.regvo;
import vo.stateVo;

/**
 * Servlet implementation class stateController
 */
@WebServlet("/stateController")
public class stateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		if(flag.equals("loadcountry")){
			loadcountry(request,response);
			response.sendRedirect("addState.jsp");
		}
		else if(flag.equals("searchcountry")){
			searchCountry(request,response);
			response.sendRedirect("displayState.jsp");
		}
		else if(flag.equals("delete")){
			deleteState(request,response);
			
			deletecountry(request,response);
			
			searchCountry(request,response);
			response.sendRedirect("displayState.jsp");
		}
		
	}

	protected void deletecountry(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("fid"));
		FKeyVo v = new  FKeyVo();
		v.setId(id);
		FkeyDao dao = new FkeyDao();

		dao.delete(v);
		
		
	}

	protected void deleteState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		stateVo v = new  stateVo();
		v.setId(id);
		stateDao dao = new stateDao();
		dao.delete(v);

	}

	protected void searchCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stateDao d = new stateDao();
		List ls= d.search();
		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);
	}

	protected void loadcountry(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		FkeyDao d = new FkeyDao();
		List ls  = d.search();
		HttpSession s1 = request.getSession();
		s1.setAttribute("list", ls);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag=  request.getParameter("flag");
		if(flag.equals("insertstate")){
			insertstate(request,response);
			
		}
	}

	protected void insertstate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("country");
		String Tname = request.getParameter("state");
		int i  = Integer.parseInt(sid);
		
		FKeyVo fKeyVo = new FKeyVo();
		fKeyVo.setId(i);
		
		stateVo vo = new stateVo();
		vo.setStateName(Tname);
		vo.setCountry(fKeyVo);
		
		stateDao d = new stateDao();
		d.insert(vo);
	}

}
