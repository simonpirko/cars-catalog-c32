<%@page import="by.catalog.domain.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Account</title>
</head>
<body>
    <h1>"User's account"</h1>
    <ul>
        <c:forEach items="{requestScope.currentUser}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>



    <button onclick="location.href = '/logout';">Logout</button>
    <button onclick="location.href = '/changeAdverts';">Logout</button>
    <button onclick="location.href = '/';">To main page</button>

</body>
</html>
