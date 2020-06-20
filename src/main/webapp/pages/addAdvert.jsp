<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddAdvert</title>
</head>
<body>

<h2>Create a new advert</h2>

<c:if test="${!requestScope.checkModelCar}">
<form action="/addAdvert" method="get">
    <p>    <select name="mark">
        <option disabled>Enter model car</option>
        <option value="Audi"> Audi </option>
        <option value="Mazda"> Audi A4 </option>
        <option value="Mercedes"> Mazda MX-30 </option>
        </select></p>
    <button>Submit</button>
    </c:if>

<c:if test="${requestScope.checkModelCar}">
    <ul>
         <form action="/addAdvert" method="post">
             Select model car  <select name="model">
                <c:forEach items="${requestScope.listCar}" var="last">
                    <option value= "${last}"> ${last} </option>
                </c:forEach>
            </select>
    </ul>
    <p> Color car <input type="text" name="color" placeholder="Color"></p>
    <p> Production year <input type="text" name="year" placeholder="Year"></p>
    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"></p>
    <button>Submit</button>
</c:if>


</form>

<b>${requestScope.checkAdvert}</b>

</body>
</html>
