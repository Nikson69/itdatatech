<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ITdatatech Nikita</title>
</head>
<body>
	<div class="generic-container">
		<div class="authbar">
			<span>Привет <strong>${loggedinuser}</strong>, тебе тут не рады.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Выходи</a> или иди на <a href="<c:url value="/" />">главную</a> (:</span>
		</div>
	</div>
</body>
</html>