
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>

</head>
<body>

<form action="/auth" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="text" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${requestScope.messageAuth}</p>
<a href="/">Return</a>


</body>
</html>
