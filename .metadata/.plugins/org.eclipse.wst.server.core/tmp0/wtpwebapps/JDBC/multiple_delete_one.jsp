<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="multiple_delete_two.jsp">
<%

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s = c.createStatement();
ResultSet r= s.executeQuery("SELECT * FROM website ");
%>
<table border ="2px solid red">
<tr>
<td>Id</td>
<td>firstname</td>
<td>lastname</td>
<td>username</td>
<td>Action</td>
</tr>
<%
while(r.next()){
	int i  = r.getInt("id");
	String d = r.getString("firstname");
	String d1 = r.getString("lastname");
	String u = r.getString("username");	
		%>
	<tr>
	<td><%out.println(i); %></td>
	<td><%out.println(d); %></td>
	<td><% out.println(d1); %></td>
	<td><% out.println(u); %></td>
	<td><input type="checkbox" name="box" value=<%= r.getInt("id") %>></td>
	
	</tr>
  	
<% }s.close();
r.close();
%>
</table>
<input type="submit" value="submit">
</form>
</body>
</html>