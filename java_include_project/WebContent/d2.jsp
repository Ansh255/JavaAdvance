<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="d3.jsp">
username :
	<input type="text" name="user"><br>
	<br>
	password :
	<input type="password" name="pass"><br>
	<%@include file="d1.jsp" %><br>
	<br>
<input type="submit" value="Login"><br>
	</form>
</body>
</html>