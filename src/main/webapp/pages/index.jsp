<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<html>
<head>
    <h1>Hello${sessionScope.currentUser.name}!
        It's Cars Catalog ver.1</h1>

    <c:if test="${!sessionScope.checkAuth}">
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <nav class="nav" >
        <a class="nav-link active" href="/reg">Registration</a>
        <a class="nav-link" href="/auth">Authorisation</a>
    </nav>
    </nav>
    </c:if>


    <c:if test="${sessionScope.checkAuth}">
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <nav class="nav" >
            <a class="nav-link active" href="/addAdvert">Add Advert</a>
            <a class="nav-link" href="/pers">PersonalAccount</a>
            <a class="nav-link" href="/logout">Logout</a>
        </nav>
    </nav>
    </c:if>


</head>
<body>

<div class="container">
    <div class="row row-cols-3">

        <c:forEach items="${requestScope.advertList}" var="last">
            <div class="col">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${last.modelCar}</h5>
                        <p class="card-text">${last}</p>
                        <a href="/advert?id=${last.id}">Go somewhere</a>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>
</div>


<p>Today: <c:out value="<%=new java.util.Date()%>"/></p>

<%--<ul style="list-style: decimal">--%>
<%--    <c:forEach items="${requestScope.adsList}" var="adsList">--%>
<%--        <li>${adsList}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

</body>

</html>
