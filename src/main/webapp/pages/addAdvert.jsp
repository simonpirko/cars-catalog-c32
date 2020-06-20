<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddAdvert</title>
</head>
<body>

<h2>Create a new advert</h2>

<form action="/addAdvert" method="post">
    <p>    <select name="model">
        <option disabled>Enter model car</option>
        <option value="Audi A8"> Audi A8 </option>
        <option value="Audi A4"> Audi A4 </option>
        <option value="Mazda MX-30"> Mazda MX-30 </option>
        <option value="Mercedes-Benz A-Class"> Mercedes-Benz A-Class  </option>
    </select></p>
    <p> Color car <input type="text" name="color" placeholder="Color"></p>
    <p> Production year <input type="text" name="year" placeholder="Year"></p>
    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"></p>
    <button>Submit</button>
</form>

<b>${requestScope.checkAdvert}</b>

</body>
</html>
