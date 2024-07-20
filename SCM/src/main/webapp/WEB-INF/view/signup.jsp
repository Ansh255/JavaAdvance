<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<% %>
<title>Bootstrap demo</title>
<link
	href="<%=request.getContextPath()%>https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>css/style.css">
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Smart Contact Manager</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse " id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 text-uppercase  ">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="base">about</a></li>

					<li class="nav-item"><a class="nav-link" aria-disabled="true">Login</a></li>
					<li class="nav-item"><a class="nav-link" aria-disabled="true"
						href="signup">Signup</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success " type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">

				<div class="my-cart mt-3">

					<div class="container text-center">
						<img "style="width: 40px" height="40px" alt="not found"
							src="/img/registerimage.png">
					</div>

					<h1 class="text-center">Registration Form</h1>

					<f:form action="register" method="post" modelAttribute="userVO">

						<div class="mb-3">
							<span for="exampleInputEmail1" class="form-label">Name </span>

							<f:input type="text" class="form-control" path="name"
								id="exampleInputEmail1" aria-describedby="emailHelp" />
							<span class="text-color-red-new"><f:errors path="name" /></span>

						</div>

						<div class="mb-3">
							<span for="exampleInputPassword1" class="form-label">Email</span>
							<f:input type="email" class="form-control" path="email"
								id="exampleInputPassword1" />
						</div>

						<div class="mb-3">
							<span for="exampleInputPassword1" class="form-label">Password</span>
							<f:input type="password" class="form-control" path="password"
								id="exampleInputPassword1" />
							<span class="text-color-red-new"><f:errors path="password" /></span>
						</div>

						<div class="mb-3">
							<span class="form-label form-group">Description</span>
							<f:textarea placeholder="Enter something about you" rows="8"
								type="text" class="form-control" path="about"
								id="exampleInputPassword1" />
						</div>
						<div class="form-group form-check">

							<input type="checkbox" class="form-check-input" /> <span>Accept
								terms and conditons</span>


						</div>

						<div class="container text-center">
							<f:button type="submit" class="btn bg-primary text-white ">Submit</f:button>
							<f:button type="reset" class="btn btn-warning text-white "> Reset</f:button>

						</div>

					</f:form>




				</div>


			</div>


		</div>




	</div>









	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>