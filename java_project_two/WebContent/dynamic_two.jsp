<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action=dynamic_three.jsp>
Username :
<input type="text" name="username"><br>
<br>
Password :
<input type="password" name="password"><br>
<br>
<input type="submit" value="Login"><br>
<br>
	
<%String s12 = (String)session.getAttribute("error");
if(s12!=null){
	
out.println(s12);
session.removeAttribute("error");
}%>
</form>


</body>
</html>