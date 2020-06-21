<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddAdvert</title>
</head>
<body>

<b><a href="/">Return</a></b>
<h2>Create a new advert</h2>

<c:if test="${!requestScope.checkModelCar}">
    <ul>
        <form action="/addAdvert" method="get">
            Select mark car  <select name="mark">
            <c:forEach items="${requestScope.listMark}" var="list">
                <option value= "${list}"> ${list} </option>
            </c:forEach>
        </select>
    </ul>
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
    <ul>
        <form action="/addAdvert" method="post">
            Select production year  <select name="year">
            <c:forEach items="${requestScope.listYear}" var="list">
                <option value= "${list}"> ${list} </option>
            </c:forEach>
        </select>
    </ul>
    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"></p>
    <button>Submit</button>
</c:if>
</form>
<b>${requestScope.checkAdvert}</b>
</body>
</html>
