<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${sessionScope.adminBoolean}">

</c:if>
<c:if test="${sessionScope.adminBoolean}">
    <a href="/adminMenu" class="btn btn-primary">Admin menu</a>
    <div class="container">
        <div class="row row-cols-3">
            <c:forEach items="${requestScope.allAdvert}" var="last">
                <div class="col">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${last.markCar} ${last.modelCar}</h5>
                            <p class="card-text">${last}</p>
                            <a href="/advert?id=${last.id}">Check info</a>
                            <a href="/editAdvert?id=${last.id}" class="btn btn-primary">Edit advert</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>
</body>
</html>
