<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin ${requestScope.currentAdminName} page</title>
</head>
<body>

<h1>"${requestScope.currentAdminName}'s account"</h1>
<ul>
    <c:forEach items="{requestScope.currentAdmin}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<a href="/listAllUsers">Show all users</a>
<a href="/deleteUsers">Delete user</a>
<a href="/addUser">Add new user</a>
<a href="/changeUserData">Change user's data</a>
<a href="/showAllAdverts">Show all adverts</a>
<a href="/changeAdverts">Change adverts</a>
<a href="/deleteAdverts">Delete adverts</a>
<a href="/delete comments">Delete comments</a>

<a href="/deleteMyAcc">Delete my account</a>
<a href="/index">Go to main page</a>
<a href="/">Logout</a>
</body>
</html>
