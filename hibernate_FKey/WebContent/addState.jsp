<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="stateController" method="post">
		<input type="hidden" name="flag" value="insertstate"> country
		:<select name="country">
			<c:forEach items="${sessionScope.list}" var="i">
				<option value="${i.id }">${i.country}</option>
			</c:forEach>
		</select> <input type="text" name="state"> <input type="submit">
	</form>
</body>
</html>