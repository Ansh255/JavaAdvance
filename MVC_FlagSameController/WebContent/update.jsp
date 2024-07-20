<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	<c:forEach var="i" items="${sessionScope.list}">

		<form action="registerController">
		<input type="hidden" name="flag" value="update"> 
			FirstName <br> <input type="text" name="firstName"
				value="${i.fn}"><br> LastName <br> <input
				type="text" name="lastName" value="${i.ln}"><br> 
				<input type="hidden" value="${i.id }" name="id">
				<input
				type="submit">
		</form>
	</c:forEach>
</body>
</html>