<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
td{
border : 2px solid red;}</style>
<body>

<%System.out.println("teddy"); 
System.out.println("day");out.println("HI");%><br><%int i;
for(i=0;i<5;i++){out.println("KAHAN");}%><br>
<br>
<table>
<% int i ;
for(i=0;i<6;i++){
	if(i%2==0){
		%><tr><td><% out.println("*"); %></td></tr><% 
	}
	else{
		%><tr><td><% out.println("#"); %></td></tr><% 
	}
	
}
%>
</table>

</body>
</html>