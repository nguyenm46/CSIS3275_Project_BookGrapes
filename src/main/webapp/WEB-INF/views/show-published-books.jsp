<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookGrapes - Published Book</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>

	<%-- <div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h1>Your Published Books</h1>
			<hr />
			<form:form action="showPublishedBooks" cssClass="form-horizontal"
				method="post" modelAttribute="showpublishedbook" id="showBooklist">
				<form:hidden path="code" cssClass="form-control" />
				<form:hidden path="booktitle" cssClass="form-control" />

				<table class="table table-striped table-bordered">
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.code} ${book.booktitle}</td> 
							<td><a href="#?bookcode=${book.code}" onclick="document.getElementById('code').value='${book.code}';
							document.getElementById('booktitle').value='${book.booktitle}';
							document.getElementById('showBooklist').submit();">Edit</a></td>
						</tr>
					</c:forEach>

				</table>
			</form:form>

		</div>
	</div> --%>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h1>Your Published Books</h1>
			<hr />
			<table class="table table-striped table-bordered">
				<c:forEach var="book" items="${books}">
					<tr>
						<td>Book ID: ${book.code} , Book Title: ${book.booktitle}</td>
						<td><a href="edit-book?bookcode=${book.code}">Edit</a></td>
					</tr>
				</c:forEach>

			</table>
			<br /> <a href="publisherhome">Back to Homepage</a>

		</div>
	</div>
</body>
</html>
