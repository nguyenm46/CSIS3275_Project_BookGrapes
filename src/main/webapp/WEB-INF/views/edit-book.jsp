<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookGrapes - Book Registration</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<!-- Hsueh-Cheng Liu 300280496 -->

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Edit book</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title"></div>
				</div>
				<div class="panel-body">
					<form:form action="editBook" cssClass="form-horizontal"
						method="post" modelAttribute="ebook">
						<div class="form-group">
							<label for="code" class="col-md-3 control-label"> Book ID</label>
							<div class="col-md-9">
								<form:input path="code" value="${bookcode}"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="booktitle" class="col-md-3 control-label">
								Book title</label>
							<div class="col-md-9">
								<form:input path="booktitle" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="author" class="col-md-3 control-label">Author</label>
							<div class="col-md-9">
								<form:input path="author" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="publishedyear" class="col-md-3 control-label">Publisher
								year </label>
							<div class="col-md-9">
								<form:input path="publishedyear" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
