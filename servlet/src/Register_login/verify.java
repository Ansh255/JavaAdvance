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
 * Servlet implementation class verify
 */
@WebServlet("/verify")
public class verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String s2 = request.getParameter("Username");
//		String s3 = request.getParameter("Password");
//		HttpSession f = request.getSession();
//		
//		f.setAttribute("username",s2 );
//		f.setAttribute("password",s3 );
//		
//		String p = f.getAttribute("user").toString();
//		String pw = f.getAttribute("pass").toString();
//		
//		if(s2.equals(p) && s3.equals(pw)){
//			response.sendRedirect("welcome.jsp");
//		}
		try{
			String s2 = request.getParameter("Username");
			String s3 = request.getParameter("Password");
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","root");
			Statement F = c.createStatement();
			F.executeUpdate("INSERT INTO base_login(fn,ln) VALUES('"+s2+"','"+s3+"')");
			F.close();
			c.close();
			response.sendRedirect("welcome.jsp");
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
