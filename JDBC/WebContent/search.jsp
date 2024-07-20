<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String v = request.getParameter("fn");
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s = c.createStatement();
ResultSet r= s.executeQuery("SELECT * FROM register where fn = '"+v+"'");
while(r.next()){
	String d = r.getString("fn");
	String d1 = r.getString("ln");
	String d2 = r.getString("gender");
	String d3 = r.getString("country");
	String d4 = r.getString("address");
	String d5 = r.getString("hobbies");
	out.println(d);
	out.println(d1);
	out.println(d2);
	out.println(d3);
	out.println(d4);
	out.println(d5);
	     	
}
s.close();
r.close();
%>

</body>
</html>