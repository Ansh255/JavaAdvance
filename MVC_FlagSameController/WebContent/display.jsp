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
	<form action="registerController">
		<input type="hidden" name="flag" value="multipledel">
		<table border="1">
			<td>Id</td>
			<td>fn</td>
			<td>ln</td>
			<td>action</td>
			<td>CheckBox</td>

			<c:forEach items="${sessionScope.list}" var="i">
				<tr>
					<td>${i.id}</td>
					<td>${i.fn}</td>
					<td>${i.ln}</td>
					<td><a href="registerController?id=${i.id}&flag=delete">Delete</a>
						<a href="registerController?id=${i.id}&flag=edit">Edit</a></td>
					<td><input type="checkbox" name="box" value="${i.id }"></td>

				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="MultipleDelete">
	</form>

</body>
</html>