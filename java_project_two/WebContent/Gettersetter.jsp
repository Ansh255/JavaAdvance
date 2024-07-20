<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java_project_two.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="s1" class="java_project_two.Student"/>
<jsp:setProperty property="fn" name="s1" value="java"/>
<jsp:setProperty property="ln" name="s1" value="abc"/>
<jsp:getProperty property="fn" name="s1"/>
<jsp:getProperty property="ln" name="s1"/>


</body>
</html>