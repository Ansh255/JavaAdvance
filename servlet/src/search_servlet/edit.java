package search_servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		try{
			
		PrintWriter q = response.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","root");
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("SELECT * FROM base_login");
		String d=null;
		String d1=null;
		int i =0;
		while(r.next()){
			 i  = r.getInt("id");
			d = r.getString("fn");
			d1 = r.getString("ln");
			
		}
		
		q.write("<form action='update'>");
		q.write("<input type='hidden' name='id' value="+i+">");
		q.write("firstname <input type='text' value="+d+" name='one' >");
		q.write("<br>");
		q.write("lastname <input type='text' value="+d1+" name='two' >");
		q.write("<br>");
		q.write("<input type='submit'>");
		q.write("</form>");
		
		
		s.close();
		c.close();
		
	}catch(Exception e){}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
