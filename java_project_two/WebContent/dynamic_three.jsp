<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String s1 = (String)session.getAttribute("user");
		String s2 = (String)session.getAttribute("pass");
		String c1 = request.getParameter("username");
		String c2 = request.getParameter("password");

		if (s1.equals(c1) && s2.equals(c2)) {
			response.sendRedirect("dynamic_four.jsp");
			
		} else {

			session.setAttribute("error","Invalid Password or Username");
			response.sendRedirect("dynamic_two.jsp");
		}
	%>

</body>
</html>