<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<link>
    <meta charset="utf-8">
    <meta name="_header" content="${_csrf.headerName}">
    <meta name="_token" content="${_csrf.token}">
    <title>ITdatatech Nikita</title>

    <link href="<c:url value='https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css' />"
          rel="stylesheet"></link>
<link href="<c:url value='/src/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/src/css/bootstrap.css' />" rel="stylesheet"></link>
</head>

<body>
<%@include file="header.jsp" %>
<sec:authorize access="hasRole('ADMIN')">
    <main role="ADMIN" id="root" ></main>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
    <main role="USER" id="root"></main>
</sec:authorize>
<div id="data-main"></div>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
<script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>

<script src="dist/bundle.js"></script>
<script src="http://localhost:8081/bundle.js"></script>

</body>
</html>