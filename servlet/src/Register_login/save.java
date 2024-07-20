package Register_login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 * Servlet implementation class save
 */
@WebServlet("/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String s = request.getParameter("fn");
		String s1 = request.getParameter("ln");
		String s2 = request.getParameter("user");
		String s3 = request.getParameter("pass");
//		HttpSession f = request.getSession();
//		f.setAttribute("fn",s );
//		f.setAttribute("ln",s1 );
//		f.setAttribute("user",s2 );
//		f.setAttribute("pass",s3 );
//		response.sendRedirect("login.jsp");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","root");
		Statement F = c.createStatement();
		F.executeUpdate("INSERT INTO base(fn,ln,user,pass) VALUES('"+s+"','"+s1+"','"+s2+"','"+s3+"')");
		F.close();
		c.close();
		response.sendRedirect("login.jsp");
		}
		catch(Exception e){
			System.out.print(e);
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