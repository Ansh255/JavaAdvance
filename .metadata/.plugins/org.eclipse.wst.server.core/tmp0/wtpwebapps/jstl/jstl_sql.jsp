<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://java.sun.com/jstl/sql_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:setDataSource driver="com.mysql.jdbc.Driver" var="i" user="root" password="root" url="jdbc:mysql://localhost/jdbc" scope="session"/>

<s:query dataSource="${i}" var="i2" >
select * from website;</s:query>
<c:forEach items='${i2.rows}' var="i3">
${i3.firstname}
${i3.lastname}
<br>
</c:forEach>

<s:update dataSource="${i}" var="a">
UPDATE website SET firstname = 'ansh' WHERE id = 4
</s:update>


</body>
</html>