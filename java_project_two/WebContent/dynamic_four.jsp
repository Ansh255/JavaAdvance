<%@ page language="java" contentType="text/; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>Welcome!<%
String s = (String)session.getAttribute("fn");
String s1 = (String)session.getAttribute("ln");
out.println(" ");
 
out.println(s);
out.println(s1);
%><%@ page       %>


</body>
</html>
