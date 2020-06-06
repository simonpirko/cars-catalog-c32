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

    <h3>Change user's data</h3>
    <form action="account.jsp">
        <select name="changesAcc">
            <option value="changeName">Change your name</option>
            <option value="changeLastName">Change your last name</option>
            <option value="changeLogin">Change your login</option>
            <option value="changePass">Change your password</option>
            <option value="changePhone">Change your phone</option>
        </select>
        <button>Apply</button>
    </form>

    <button onclick="location.href = '/logout';">Logout</button>
    <button onclick="location.href = '/changeAdverts';">Logout</button>
    <button onclick="location.href = '/';">To main page</button>

</body>
</html>
