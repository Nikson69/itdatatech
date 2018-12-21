<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/src/image/favicon.ico">

    <title>ITdatatech Nikita</title>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value='/src/css/signin.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/src/css/app.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/src/css/bootstrap.css' />" rel="stylesheet"></link>
</head>

<body class="text-center">
<div id="test"></div>
<form class="form-signin" method="post">
    <img class="mb-4" src="/src/image/favicon.ico" alt="" width="72"
         height="72">
    <h1 class="h3 mb-3 font-weight-normal">Войдите в систему</h1>
    <label for="username" class="sr-only">Имя пользователя</label>
    <input type="text" id="username" name="ssoId" class="input-group form-control" placeholder="Логин" required
           autofocus="">
    <label for="inputPassword" id="password" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="input-group form-control" placeholder="Пароль"
           required>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="input-group checkbox mb-3">
        <label>
            <input type="checkbox" name="remember-me"> Запомнить меня
        </label>
    </div>
    <div class="form-actions">
        <input type="submit"
               class="btn btn-lg btn-primary btn-block" value="Войти">
    </div>
    <p class="mt-5 mb-3 text-muted">© 2018</p>
</form>

</body>
</html>
