<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="jstl_fmrt.jsp">English</a><br>

<a href="jstl_fmrt.jsp?f=guj">Gujarti</a><br>

<a href="jstl_fmrt.jsp?f=hi">hindi</a><br>

<br>
<br>
<f:setLocale value="${param.f}"/>
<f:setBundle basename="m" var="i"/>
<f:message bundle="${i}" key="fn" ></f:message>
<input type="text"><br>	

<f:message bundle="${i}" key="ln" ></f:message>
<input type="text">

</body>
</html>