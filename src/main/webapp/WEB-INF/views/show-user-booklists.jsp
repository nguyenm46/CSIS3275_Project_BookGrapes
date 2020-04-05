<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookGrapes - Booklist</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%@ page isELIgnored="false"%>
</head>
<body>

	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h1>Your Booklist</h1>
			<hr />
			<table  modelAttribute="showbooks" class="table table-striped table-bordered">
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.code} ${book.booktitle}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
