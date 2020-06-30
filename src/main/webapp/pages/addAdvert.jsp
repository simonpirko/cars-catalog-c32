<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
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
            <li> Select mark car  <select name="mark">
            <c:forEach items="${requestScope.listMark}" var="list">
                <option value= "${list}"> ${list} </option>
            </c:forEach>
        </select>
            </li>
    </ul>
    <button>Submit</button>
    </c:if>

<c:if test="${requestScope.checkModelCar}">
    <ul>
         <form action="/addAdvert" method="post">
             <li>Select model car  <select name="model">
                <c:forEach items="${requestScope.listCar}" var="last">
                    <option value= "${last}"> ${last} </option>
                </c:forEach>
            </select>
             </li>

             <li>Select color car  <select name="color">
    <c:forEach items="${requestScope.colorList}" var="list">
        <option value= "${list}"> ${list} </option>
    </c:forEach>
             </select>
             </li>

             <li>Select production year  <select name="year">
            <c:forEach items="${requestScope.listYear}" var="list">
                <option value= "${list}"> ${list} </option>
            </c:forEach>
        </select>
             </li>

    </ul>

    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"></p>

    <div class="form-group">
        <label for="exampleFormControlTextarea1">Specification</label>
        <textarea class="form-control" name="specificationAdvert" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>

    <button>Submit</button>


</c:if>
</form>
<b>${requestScope.checkAdvert}</b>
</body>
</html>
