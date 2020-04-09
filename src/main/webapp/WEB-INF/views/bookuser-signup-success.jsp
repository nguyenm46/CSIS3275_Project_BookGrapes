<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookGrapes - User</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%@ page isELIgnored="false"%>

<!-- Hsueh-Cheng Liu 300280496, Khue Nguyen 300300461 -->

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h1>${message}</h1>
			<hr />
			 
			<table class="table table-striped table-bordered">
				<tr>
					<td><b>Username</b>: ${bookuser.username}</td>
				</tr>
				<tr>
					<td><b>Full Name </b> : ${bookuser.fullname}</td>
				</tr>
				<tr>
					<td><b>D.O.B </b> : ${bookuser.dob}</td>
				</tr>
				<tr>
					<td><b>Email </b>: ${bookuser.email}</td>
				</tr>
			</table>

			<br/>
			<a href="home">Back to Homepage</a>
		</div>
	</div>
</body>
</html>
