<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=two.jsp>
Username :
<input type="text" name="first"><br>
<br>
Password :
<input type="password" name="last"><br>
<br>
country : 
<select name ="country">
    <option value="India">India</option>
    <option value="usa">USA</option>
</select>
<br>
State : 
<select name ="state">
    <option value="Gujarat">Gujarat</option>
    <option value="Bengal">Bengal</option>
</select>
<br>
<input type="text" value="Address" name="textarea">
<br>
Gender:<br>
male<input type="radio" value="male" name="d"><br>
female<input type="radio" value="female" name="d"><br>
<br>
hobbies:
cricket<input type="checkbox" name="one" value ="cricket" checked="checked" >
volley<input type="checkbox" name="one" value ="VOlleyBall"checked="checked">
foot<input type="checkbox" name="one" value ="football"checked="checked">

<input type="submit" value="submit">

</form>
</body>
</html>