
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<title>Insert title here</title>
<script src="index.js"></script>
</head>
<body onload="getUser()">
	<button onclick="addUserValue() ">Adduser</button><br> <br>
	
	<table class="table table-borderless" id="table-content">
		<thead class="table-dark">
			<tr>
				<th scope="col">id</th>
				<th scope="col">First</th>
				<th scope="col">Last</th>
				<th scope="col">Username</th>
				<th scope="col">password</th>
				<th scope="col">delete</th>
			</tr>
		</thead>
	</table>

</body>
</html>