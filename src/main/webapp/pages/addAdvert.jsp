
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddAdvert</title>
</head>
<body>

<h2>Create a new advert</h2>

<form action="/addAdvert" method="post">
    <p> Model car   <input type="text" name="model" placeholder="Model"> </p>
    <p> Color car   <input type="text" name="color" placeholder="Color"> </p>
    <p> Production year  <input type="text" name="year" placeholder="Year"> </p>
    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"> </p>
    <button>Submit</button>
</form>

<b>${requestScope.checkAdvert}</b>

</body>
</html>
