
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change ${requestScope.currenUserName} Data</title>
</head>
<body>
<h3>Change user's data</h3>

<h3>"Present user's data:"</h3>
<ul>
    <c:forEach items="{requestScope.currentUser}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<form action="changeUserData.jsp" method="post">

    <input type="text" name="newName" placeholder="NewName">
    <select name="changesAccInfo">
        <option value="changeName">Change your name</option>
        <option value="changeLastName">Change your last name</option>
        <option value="changeLogin">Change your login</option>
        <option value="changePass">Change your password</option>
        <option value="changePhone">Change your phone</option>
    </select>
    <button>Apply</button>
</form>
</body>
</html>
