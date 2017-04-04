<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
    href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

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

<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Spring Boot</a>
            </div>

        </div>
    </nav>

    <div class="container">

        <div class="starter-template"></div>


        <form:form method="POST" action="${contextPath}/login" modelAttribute="userForm" class="form-signin">
            <h2 class="form-heading">Log in</h2>
            <span>${message}</span>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control"
                        placeholder="Username" autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control"
                        placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>
            <span>${error}</span>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form:form>
    </div>

    <script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>