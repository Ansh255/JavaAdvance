<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String s = request.getParameter("first");
String s1 = request.getParameter("last");
String sp="first";
String sl="last";
if(s.equals(sp) && s1.equals(sl)){
	response.sendRedirect("welcome.jsp");
}
else{
	response.sendRedirect("register.jsp");
}
%>
</body>
</html>