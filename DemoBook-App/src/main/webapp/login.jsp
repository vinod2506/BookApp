
<%
 String msg="";
if(session.getAttribute("error")!=null){
	msg=(String)session.getAttribute("error");
	session.removeAttribute("error");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<form action="login" method="get">
					<div class="form-group">
						<label for="username">USERNAME</label> <input type="text"
							name="username" class="form-control">
					</div>

					<div class="form-group">
						<label for="mobile">Password</label> <input type="text"
							name="password" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
					<a href="register.jsp" class="btn btn-primary">Register</a>
					
					<% if(msg !=""){%>
					<div class="alert alert-danger mt-1" role="alert">
                         <%= msg %>
                       </div>
					
					<%} %>
</body>
</html>