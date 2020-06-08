<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change ${requestScope.currenUserName} Data</title>
</head>
<body>
<h3>Change user's data</h3>

<h3>"${requestScope.currentUserName} data:"</h3>
<ul>
    <c:forEach items="${sessionScope.currentUser}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<form action="/changeUserData" method="post">

    <input type="text" name="newName" placeholder="NewName">
    <input type="text" name="newLastName" placeholder="newLastName">
    <input type="text" name="newLogin" placeholder="newLogin">
    <input type="text" name="newPass" placeholder="newPass">
    <input type="text" name="newPhone" placeholder="newPhone">

    <button>Apply</button>
</form>

<a href="/">Go to main page</a>

</body>
</html>
