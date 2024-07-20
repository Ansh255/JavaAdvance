<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
String s=request.getParameter("user");
String s1=request.getParameter("pass");
String s2=request.getParameter("fn");
String s3=request.getParameter("ln");

session.setAttribute("fn",s2);
session.setAttribute("ln",s3);
session.setAttribute("user",s);
session.setAttribute("pass",s1);

response.sendRedirect("dynamic_two.jsp");	%>

</body>
</html>