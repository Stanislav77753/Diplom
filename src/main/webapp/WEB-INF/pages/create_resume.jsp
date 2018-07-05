<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>
<header>
    <div class="container">
        <img src="/resources/img/logo1.png" alt="searchjob" class="logo">
    </div>
</header>
<div class="container">

    <form:form method="POST" modelAttribute="resumeForm" class="form-signin">
        <h2 class="form-signin-heading">Create resume</h2>
        <spring:bind path="nameResume">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="nameResume" class="form-control" placeholder="Name"
                            autofocus="true"></form:input>
                <form:errors path="nameResume"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="salaryResume">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="salaryResume" class="form-control" placeholder="Salary"></form:input>
                <form:errors path="salaryResume"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="experienceResume">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="experienceResume" class="form-control" placeholder="Experience"
                            autofocus="true"></form:input>
                <form:errors path="experienceResume"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="descriptionResume">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="descriptionResume" class="form-control" placeholder="Description"
                            autofocus="true"></form:input>
                <form:errors path="descriptionResume"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>