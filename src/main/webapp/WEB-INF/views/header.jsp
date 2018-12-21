<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/">Pic.ru</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="nav-item active">
                        <a class="nav-link" href="/create">Создать <span class="sr-only"></span></a>
                    </li>
                </sec:authorize>
            </ul>
            <form class="form-inline mt-2 mt-md-0" action="/filter">
                <input class="form-control mr-sm-2" type="text" name="name" placeholder="Введите запрос " aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Найти</button>
            </form>
            <div class="mx-2"></div>
            <form class="form-inline mt-2 mt-md-0" action="/logout">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Выйти</button>
            </form>
        </div>
    </nav>
</header>