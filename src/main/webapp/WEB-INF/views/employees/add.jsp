<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>


<html>
<head>
    <title>Ajouter employee</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter un employee</h1>
        <form:form method="post" action="./saveManager" modelAttribute="employees" >
            <form:input path="id" type="hidden" />
            <div class="form-group">
                <label for="name">nom complete</label>
                <form:input path="name" cssClass="form-control"  placeholder="nom complete" />
                <form:errors path="name" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="address">address</label>
                <form:input path="address" cssClass="form-control"  placeholder="address" />
                <form:errors path="address" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="phone">phone</label>
                <form:input path="phone" cssClass="form-control"  placeholder="phone" />
                <form:errors path="phone" cssClass="alert-danger" />
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    departement
                </label>
                <form:select class="form-check-label"  path="departement" multiple="false">
                    <c:forEach items="${departement}" var="dep">
                        <form:option value="${dep.name}" />
                    </c:forEach>
                </form:select>
                <form:errors path="departement" cssClass="alert-danger" />
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    remuneration
                </label>
                <form:select class="form-check-label" path="remuneration"  multiple="false">
                    <c:forEach items="${remuneration}" var="rem">
                        <form:option value="${rem.name}" />
                    </c:forEach>
                </form:select>
                <form:errors path="remuneration" cssClass="alert-danger" />
            </div>
            <form:input type="hidden" path="score" value="0" />
            <input type = "submit" value = "Submit"/>
        </form:form>
    </header>
</div>
</body>
</html>
