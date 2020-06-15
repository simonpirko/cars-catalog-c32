<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert</title>
</head>
<body>

<ul>
    <c:forEach items="{requestScope.currentAdvert}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<h3>Add message</h3>
<form name="addMessage" action="/addMessageServlet" method="post">
    <input type="text" name="addMessage" placeholder="Add message">
</form>


<a href="/">Go to main page</a>

</body>
</html>