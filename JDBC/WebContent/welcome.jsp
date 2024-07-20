<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
String s=request.getParameter("user");
String s1=request.getParameter("pass");


session.setAttribute("user",s);
session.setAttribute("Password",s1);

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s7 = c.createStatement();
ResultSet r= s7.executeQuery("SELECT * FROM  website  where username = '"+s+"' and password = '"+s1+"' ");


String d2 =null;
String d3 =null;
String d =null;
String d1 =null;
int i = 0;


if(r.next()){
	i = r.getInt("id");
	d = r. getString("firstname");
   d1 = r.getString("lastname");
   %> Welcome	<%out.println(d); 
	out.println(d1);
	%><a href = "website_change_pass.jsp?id=<%=r.getInt("id")%>"><input type="button" value="Change Password"></a><% 
}
else{
	
	response.sendRedirect("website_login.jsp");
}




s7.close();
r.close();
	
%>


</body>
</html>