<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<body>
<table border="1px solid black">
<tr>
	<th>Id</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>Username</th>
	<th>password</th>
	<th>Action</th>
</tr>
<c:forEach items="${SearchList}" var="p">
<tr>
	<td>${p.id}</td>
	<td>${p.firstName}</td>
	<td>${p.lastName}</td>
	<td>${p.loginvo.userName }</td>
	<td>${p.loginvo.passWord }</td>
	<td><a href="delete.html?regId=${p.id}">Delete</a>
	<a href="edit.html?regId=${p.id }">Edit</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>