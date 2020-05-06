<%
  String errorMsg="";
if(request.getAttribute("error")!=null){
	errorMsg=(String)request.getAttribute("error");
     
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div
				class="col-12 bg-dark text-light d-flex justify-content-center align-items-center"
				style="height: 100vh">
				<form action="register" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="username">USERNAME</label> <input type="text"
							name="username" class="form-control" aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="email">Email Address</label> <input type="text"
							name="email" class="form-control" aria-describedby="emailHelp">
						<small id="emailHelp" class="form-text text-muted">We will
							never share your email with anyone else</small>
					</div>
					<div class="form-group">
						<label for="mobile">MOBILE</label> <input type="text"
							name="mobile" class="form-control" aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="text"
							name="password" class="form-control" aria-describedby="emailHelp">
					</div>

					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="sub">
						<label class="form-check-label" for="sub">Click me out</label>
						
					</div>
					<div class="form-group">
						<label for="photos">photo</label> <input type="file"
							name="photos" class="form-control" aria-describedby="emailHelp">
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
					<a href="login.jsp" class="btn btn-primary">Login</a>
				   <%if(errorMsg!=""){ %>
					<div class="alert alert-danger" role="alert">
						<%= errorMsg%>
					</div>
				<%} %>
	
				</form>
			</div>
		</div>

	</div>


</body>
</html>