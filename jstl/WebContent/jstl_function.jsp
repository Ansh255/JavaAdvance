<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="i" value="harshal-sir-inno"></c:set>
<c:set var="j" value='${f:split(i,"-")}'></c:set>
<c:set var="z" value='${f:join(j,"-")}'></c:set>
${f:length(i)}<br><br>
${j[0] }<br>
${j[1] }<br>
${j[2] }<br><br>
${z}<br><br>
<br>	
<c:forEach items="${j}" var="q">	
${q }<br>
</c:forEach>


</body>
</html>