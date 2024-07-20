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
String s=request.getParameter("fn");
String s1=request.getParameter("ln");
String s2=request.getParameter("g");
String s3=request.getParameter("country");
String s4=request.getParameter("ad");
String[] s5=request.getParameterValues("h");
String s6="";

if(s5!=null && s5.length!=0)
{
for(int i=0;i<s5.length;i++)
{
	if(i==s5.length-1){
    s6+=s5[i];}
	else{
		s6+=s5[i]+",";
	}
}
}

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s7 = c.createStatement();
s7.executeUpdate("INSERT INTO register(fn,ln,gender,country,address,hobbies) VALUES('"+s+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s6+"')");

s7.close();
c.close();
%>

</body>
</html>