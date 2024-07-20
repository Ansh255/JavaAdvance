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
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","root");
		Statement s = c.createStatement();
		ResultSet r= s.executeQuery("SELECT * FROM base_login ");
		PrintWriter d = response.getWriter();
		d.write("<table border ='2px solid red'>");
		d.write("<tr>");
		d.write("<td>Id</td>");
		d.write("<td>UserName</td>");
		d.write("<td>PassWord</td>");
		d.write("<td>Action</td>");
		d.write("</tr>");
		while(r.next()){
			int i  = r.getInt("id");
			String o = r.getString("fn");
			String d1 = r.getString("ln");
			d.write("<tr>");
			d.write("<td>"+i+"</td>	");
			d.write("<td>"+o+"</td>");
			d.write("<td>"+d1+"</td>");
			d.write("<td><a href='delete?id="+r.getInt("id")+"'>delete</a><td>'");
			d.write("<td><a href='edit?id="+r.getInt("id")+"'>Edit</a><td>'");
			
			
		}
		s.close();
		c.close();
		
		}
		catch(Exception e){}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
