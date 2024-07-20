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

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s = c.createStatement();
ResultSet r= s.executeQuery("SELECT * FROM register ");
%>
<table border ="2px solid red">
<tr>

<td>Id</td>
<td>fn</td>
<td>ln</td>
<td>gender</td>
<td>country</td>
<td>address</td>
<td>hobbies</td>
<td> action</td>

</tr><%
while(r.next()){
	int i  = r.getInt("id");
	String d = r.getString("fn");
	String d1 = r.getString("ln");
	String d2 = r.getString("gender");
	String d3 = r.getString("country");
	String d4 = r.getString("address");
	String d5 = r.getString("hobbies");
	%>
	<tr>
	<td><%out.println(i); %></td>
	<td><%out.println(d); %></td>
	<td><% out.println(d1); %></td>
	<td><% out.println(d2); %></td>
	<td><% out.println(d3); %></td>
	<td><% out.println(d4); %></td>
	<td><% out.println(d5); %></td>
	<td><a href="delete_table.jsp?id=<%=r.getInt("id")%>">delete</a>
	<a href="update.jsp?id=<%=r.getInt("id")%>">edit</a></td>
	</tr>
  	
<% }

s.close();
r.close();
%>
</table>

</body>
</html>