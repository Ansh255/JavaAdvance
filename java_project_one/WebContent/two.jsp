<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String s = request.getParameter("first");
String s1 = request.getParameter("last");
String s2 = request.getParameter("country");
String s3 = request.getParameter("state");
String s4 = request.getParameter("textarea");
String s5 = request.getParameter("d");
String[] s6 =request.getParameterValues("one");
out.println("Welcome User : "+s); %><br><% 
out.println("Your password: "+s1);%><br><%
out.println("Your country: "+s2);%><br><%
out.println("Your state: "+s3);%><br><%
out.println("Your address: "+s4);%><br><%
out.println("Your Gender: "+s5);%><br><%
int m;
for(m=0;m<s6.length;m++){
	out.println(s6[m]);}
	%>

</body>
</html>