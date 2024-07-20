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
String s1  = request.getParameter("id");
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s = c.createStatement();
ResultSet r= s.executeQuery("SELECT * FROM website where id ='"+s1+"'");

String pass=null ;
int i =0;
if(r.next()){
	i = r.getInt("id");
	pass = r.getString("password");
}
else{
	response.sendRedirect("website_login.jsp");
}

%>
<form action="change_value.jsp">
Old Password
<input type="text" value="<%= pass %>" ><br>
new password
<input type="text" name="p"><br>
confirm password
<input type="text" name="q"><br>
<input type="hidden" name="id" value="<%= i %>">
<input type="submit" value="submit">
</form>
</body>
</html>