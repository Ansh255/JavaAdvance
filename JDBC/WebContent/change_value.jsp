<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int i = Integer.parseInt(request.getParameter("id"));
String s = request.getParameter("p");
String s1 = request.getParameter("q");
if(s.equals(s1)){
	Class.forName("com.mysql.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
	Statement F = c.createStatement();
	F.executeUpdate("UPDATE website set password ='"+s+"' where id ='"+i+"' ");
	response.sendRedirect("website_login.jsp");
	c.close();
	F.close();
}
else{
	response.sendRedirect("webiste_login.jsp");
}

%>
</body>
</html>