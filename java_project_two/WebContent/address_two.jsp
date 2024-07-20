<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="address_three.jsp">
fn <input type="text" name= "c1"><br>
ln <input type="text" name="c2"><br>
for more:<br>
<jsp:include page="address_one.jsp" ><jsp:param value="p" name="r" /></jsp:include><br>
<br>
<jsp:include page="address_one.jsp"><jsp:param value="p" name="s"/></jsp:include><br>
<br>
<input type ="submit" value="submit"><br>


</form>
</body>
</html>