<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin ${requestScope.currentUserName} page</title>
</head>
<body>

<h1>"Hello Admin ${requestScope.currentUserName}"</h1>
<ul>
    <c:forEach items="${requestScope.currentUser}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<a href="/changeUsers">Operations with user</a>
<a href="/changeAdvertisement">Operations with advert</a>
<a href="/">Homepage</a>
<a href="/logout">Logout</a>
</body>
</html>
