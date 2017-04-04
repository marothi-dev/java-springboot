<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--
    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
     -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Project Management</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Projects</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Project List:</h1>
			<c:if test="${not empty projects}">
				<c:forEach items="${projects}" var="project" varStatus="loop">

					<div class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" href="#collapse${loop.index}">${project.title}
									</a>
								</h4>
							</div>
							<div id="collapse${loop.index}" class="panel-collapse collapse">
								<div class="panel-body">
									Description: ${project.description} <br /> Start Date:
									${project.start_date} <br /> End Date: ${project.end_date} <br />
									Billable: ${project.is_billable} <br /> Active:
									${project.is_active} <br />
								</div>
								<div class="panel-footer">
									<c:if test="${not empty project.task_set}">
									Addtiona Information <br />
										<br />
										<br />
										<br /> Task Set
									<c:forEach items="${project.task_set}" var="task">
								Title: ${task.title}   Due: ${task.due_date}  Est. Hrs:  ${task.estimated_hours} <br />
								Project: ${task.project_data.title} <br />
										</c:forEach>
									</c:if>
									<c:if test="${empty project.task_set}">
										No Task Sets have been defined for this project yet.
									</c:if>
									<c:if test="${not empty project.resource_set}">
										<br />
										<br />
										<br /> Resource
									<c:forEach items="${project.resource_set}" var="resource">
								User: ${resource.user}   Start: ${resource.start_date}  End:  ${resource.end_date} <br />
								Rate: ${resource.rate}   Agreed Hrs/Month: ${resource.agreed_hours_per_month} <br />
										</c:forEach>
									</c:if>
									<c:if test="${empty project.resource_set}">
										No Resource has been assigned to this project yet.
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty projects}">
				<h1>We Currently have no projects</h1>
			</c:if>
		</div>



		<script type="text/javascript"
			src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>