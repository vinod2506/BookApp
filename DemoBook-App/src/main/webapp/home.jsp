<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%
	if (session.getAttribute("valid") == null)
		response.sendRedirect("timeout.jsp");

	String msg = "";
	if (session.getAttribute("auth") != null)
		msg = (String) session.getAttribute("auth");
	session.removeAttribute("auth");
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp"%>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-6 bg-dark text-light d-flex align-items-center"
				style="height: 60px">DEMOBOOK</div>
			<div
				class="col-6 bg-dark text-light d-flex justify-content-end align-items-center"
				style="height: 60px">
				<a href="logout" class="btn btn-primary">LOGOUT</a>
			</div>
		</div>
		<div class="row">
			<%
				if (msg != "") {
			%>
			<div class="col-6 bg-dark text-light d-flex align-items-center"
				style="height: 60px">
				<%=msg%>


			</div>
			<%
				}
			%>
		</div>
		<div>
			<table border="1">
				<thead align="center">
					<tr>
						<th>UserId</th>
						<td>${user.userId }</td>
					</tr>
					<tr>
						<th>UserName</th>
						<th>${user.userName }</th>
					</tr>
					<tr>
						<th>Password</th>
						<th>${user.password }</th>
					</tr>
					<tr>
						<th>Email</th>
						<th>${user.email }</th>
					</tr>
					<tr>
						<th>Mobile</th>
						<th>${user.mobile }</th>
					</tr>
					<tr>
						<th>Photos</th>
						<th>
						<img src="${pageContext.request.contextPath }/assets/images/${user.photo }">
						</th>
					</tr>
				</thead>
				

			</table>
		</div>
	</div>

</body>
</html>