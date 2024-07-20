<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${stateVO} 
	<f:form action="saveState.html" modelAttribute="stateVO" method="post">
	 country:
		<f:select path="countryVO.id">
			<c:forEach items="${countryList}" var="i">
				<f:option value="${i.id}">${i.country}</f:option>
			</c:forEach>
		</f:select>
			
		state: <f:input path="stateName"></f:input>
		<input type="submit" value="submit">
	</f:form>
</body>
</html>