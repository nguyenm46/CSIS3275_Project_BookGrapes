<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookGrapes - Book Review</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<!-- Hsueh-Cheng Liu 300280496 -->

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Add a review</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title"></div>
				</div>

				<div class="panel-body">
					<form:form action="addReview" cssClass="form-horizontal"
						method="post" modelAttribute="newReview">
						<div class="form-group">
							<label for="review" class="col-md-3 control-label">
								Review</label>
							<div class="col-md-9">
								<form:input path="review" cssClass="form-control" />
							</div>
							<label for="booktitle" class="col-md-3 control-label">
								Book title</label>
							<div class="col-md-9">
								<form:input path="booktitle" value="${booktitle}"
									cssClass="form-control" />
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