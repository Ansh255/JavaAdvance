<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int i = Integer.parseInt(request.getParameter("id"));
String s = request.getParameter("one");
String s1 = request.getParameter("two");
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement F = c.createStatement();
F.executeUpdate("UPDATE register set fn="+s+", ln="+s1+" where id ="+i+"");
response.sendRedirect("delete.jsp");
F.close();
c.close();




%>
</body>
</html>