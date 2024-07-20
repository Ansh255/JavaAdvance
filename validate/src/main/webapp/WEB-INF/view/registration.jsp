<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/loader.css">
</head>

<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">


				<f:form action="insert" method="post" modelAttribute="LoginVO">
					<h2 class="text-center">Login Form</h2>
					<div class="mb-3">
						<span for="exampleInputEmail1" class="form-label">Username
						</span>

						<f:input type="text" class="form-control" path="userName"
							id="exampleInputEmail1" aria-describedby="emailHelp" />
						<f:errors class="form-control" path="userName"
							id="exampleInputEmail" aria-describedby="emailHelp" />
						
						<c:forEach var="error" items="${errors}">
							<span>${error.defaultMessage}</span>
						</c:forEach>


						<div id="emailHelp" class="form-text">We'll never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<span for="exampleInputPassword1" class="form-label">Password</span>
						<f:input type="password" class="form-control" path="passWord"
							id="exampleInputPassword1" />
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" /> <span
							class="form-check-label">Check me out</span>
					</div>
					<f:button type="submit" class="btn btn-primary">Submit</f:button>
				</f:form>


			</div>
		</div>
	</div>
</body>
</html>


