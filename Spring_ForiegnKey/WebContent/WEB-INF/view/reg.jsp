<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>

	<f:form action="save.html" post="Post" modelAttribute="RegVO">
FIRST_NAME:<f:input path="firstName" />
		<br />
		<br />
LAST_NAME:<f:input path="lastName" />
		<br />
		<br />
		<f:hidden path="id" />
		<f:hidden path="loginvo.id" />
USERNAME:<f:input path="loginvo.userName" />
		<br />
		<br />
PassWord:<f:input path="loginvo.passWord" />
		<br />
		<br />

		<input type="submit" value="Submit">
	</f:form>
</body>
</html>