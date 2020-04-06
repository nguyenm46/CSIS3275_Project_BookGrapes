<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookGrapes - Publisher</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%@ page isELIgnored="false"%>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h1>${msg}${publisher.name}!</h1>
			<hr />
			<table class="table table-striped table-bordered">
				<tr>
					<td><b>Email </b>: ${user.email}</td>
				</tr>
				<tr>
					<td><b>Name </b> : ${user.name}</td>
				</tr>
			</table>
				<br />
				<a href="showRegisterNewBook">Add a new book</a>
				<br />
				<a href="showPublishedBooks">Manage published books</a>
				<br/> 
				<a href="home">Back to Homepage</a>
				<br />
				<a href="logoutPublisher">Logout</a>
				<br />

		</div>
	</div>
</body>
</html>
