<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
String s=request.getParameter("fn");	
String s1=request.getParameter("ln");
String s2=request.getParameter("userone");
String s3=request.getParameter("passone");

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s7 = c.createStatement();
s7.executeUpdate("INSERT INTO website(firstname,lastname,username,password) VALUES('"+s+"','"+s1+"','"+s2+"','"+s3+"')");

s7.close();
c.close();
response.sendRedirect("website_login.jsp");
%>

</body>
</html>