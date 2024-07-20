<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=save2.jsp>
First Name:
<input type=text name=fn><br>
Last Name:
<input type=text name=ln><br>
Gender:
<input type="radio" value="Male" name="g"/>Male
<input type="radio" value="Female" name="g"/>Female<br>
Country:
<select name="country">
	<option value="India">India</option>
	<option value="U.S.A">U.S.A</option>
	</select>
<br>
Address:
<input type="text" name="ad"><br>
Hobbies:<br>
Cricket<input type="checkbox" name="h" value="Cricket"><br>
Swimming<input type="checkbox" name="h" value="Swimming"><br>
Football<input type="checkbox" name="h" value="Football"><br>
<input type="submit" value="Click Me">
</form>

</body>
</html>	