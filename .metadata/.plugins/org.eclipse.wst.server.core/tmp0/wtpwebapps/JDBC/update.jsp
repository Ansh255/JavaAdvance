<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><% 
String s1 = request.getParameter("id");
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","root");
Statement s = c.createStatement();
ResultSet r = s.executeQuery("SELECT * FROM register WHERE id='"+s1+"'");
String d=null;
String d1=null;
int i =0;
while(r.next()){
	 i  = r.getInt("id");
	d = r.getString("fn");
	d1 = r.getString("ln");
	
}
s.close();	
c.close();


%>
<form action="edit.jsp">
<input type="hidden" name="id" value="<%= i %>">
firstname <input type="text" value="<%=d%>" name ="one" > 
lastname <input type="text" value="<%=d1%>" name ="two"> 
<input type="submit" value="submit">
</form>

</body>
</html>