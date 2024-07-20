<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="i" value="innoventa" scope="session"></c:set>
${i}
<c:forEach begin="0" end="9" step="1"> ${i} </c:forEach>
<c:if test="${i eq 'innoventa'}"><br>hellobiro<br></c:if>
<c:choose>
<c:when test="${i eq 'innoventa' }"><br> GoodAfternoon<br></c:when>
<c:when test="${i eq 'great' }"> GoodAfter</c:when>

<c:otherwise><br>out</c:otherwise>
</c:choose>
<a href="jstl_core_2.jsp">click</a>

</body>
</html>