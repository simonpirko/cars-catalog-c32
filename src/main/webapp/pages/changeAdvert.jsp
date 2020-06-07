<%@page import="by.catalog.domain.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ChangeAdvert</title>
</head>
<body>


<h3>All your adverts</h3>
<ol>
    <c:forEach items="{requestScope.currentUserAdvertsList}" var="item">
        <li>${item}</li>
    </c:forEach>
</ol>

<h3>Select advert's number to change</h3>

<form action="changeAdvert.jsp" method="get">
    <input type="number" name="advertNumber" placeholder="Advert number">
    <button>Change</button>
</form>


<h3>Change current Advert</h3>
<ul>
    <c:forEach items="{requestScope.currentAdvert}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<form action="changeAdvert.jsp" method="get">
        <input type="text" name="1" placeholder="Change model">
        <input type="text" name="2" placeholder="Change color">
        <input type="text" name="3" placeholder="Change year">
        <input type="text" name="4" placeholder="Change price">
        <input type="text" name="5" placeholder="Change description">
    <button>Apply</button>
</form>


<form action="changeAdvert.jsp" method="post">
<select name="paramForChange">
    <option disabled>Enter operation</option>
    <option value="1"> Change model </option>
    <option value="2"> Change color </option>
    <option value="3"> Change year </option>
    <option value="4"> Change price </option>
    <option value="5"> Change description </option>
</select>
</form>


<button onclick="location.href = '/logout';">Logout</button>
<button onclick="location.href = '/'">To main page</button>

</body>
</html>
