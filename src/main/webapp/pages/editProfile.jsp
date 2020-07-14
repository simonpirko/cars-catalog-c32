<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Change ${requestScope.currenUser} Data</title>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <c:if test="${!sessionScope.check4Admin}">
                    <a class="nav-link" href="/pers"> Return <span class="sr-only">(current)</span></a>
                </c:if>
                <c:if test="${sessionScope.check4Admin}">
                    <a class="nav-link" href="/changeProfile">Back<span class="sr-only">(current)</span></a>
                    <form action="/destroyProfile" method="get">
                        <a href="/destroyProfile?id=${sessionScope.idDel}" class="btn btn-danger">Delete</a>
                    </form>
                </c:if>
            </li>
        </ul>
    </div>
</nav>

<h4>Change user's data</h4>
<c:if test="${!sessionScope.adminBoolean}">
    <form action="/pers/editProfile" method="post">
        <dl class="row">
            <dt class="col-sm-2 offset-sm-1"> Name</dt>
            <dd class="col-sm-8"><input type="text" name="newName" value="${sessionScope.currentUser.name}"></dd>
            <dt class="col-sm-2 offset-sm-1"> Last Name</dt>
            <dd class="col-sm-8"><input type="text" name="newLastName" value="${sessionScope.currentUser.lastName}">
            </dd>
            <dt class="col-sm-2 offset-sm-1"> Login</dt>
            <dd class="col-sm-8"><input type="text" name="newLogin" value="${sessionScope.currentUser.login}"></dd>
            <dt class="col-sm-2 offset-sm-1"> Password</dt>
            <dd class="col-sm-8"><input type="text" name="newPass" value="${sessionScope.currentUser.password}"></dd>
            <dt class="col-sm-2 offset-sm-1"> Phone</dt>
            <dd class="col-sm-8"><input type="text" name="newPhone" value="${sessionScope.currentUser.phone}"></dd>
        </dl>
        <button>Apply</button>
    </form>
</c:if>

<c:if test="${sessionScope.adminBoolean}">

    <c:if test="${sessionScope.check4Admin}">
        <form action="/pers/editProfile" method="get">
        </form>
    </c:if>
    <form action="/pers/editProfile" method="post">
        <dl class="row">
            <dt class="col-sm-2 offset-sm-1"> Name</dt>
            <dd class="col-sm-8"><input type="text" name="newName" value="${sessionScope.user4Admin.name}"></dd>
            <dt class="col-sm-2 offset-sm-1"> Last Name</dt>
            <dd class="col-sm-8"><input type="text" name="newLastName" value="${sessionScope.user4Admin.lastName}">
            </dd>
            <dt class="col-sm-2 offset-sm-1"> Login</dt>
            <dd class="col-sm-8"><input type="text" name="newLogin" value="${sessionScope.user4Admin.login}"></dd>
            <dt class="col-sm-2 offset-sm-1"> Password</dt>
            <dd class="col-sm-8"><input type="text" name="newPass" value="${sessionScope.user4Admin.password}"></dd>
            <dt class="col-sm-2 offset-sm-1"> Phone</dt>
            <dd class="col-sm-8"><input type="text" name="newPhone" value="${sessionScope.user4Admin.phone}"></dd>
        </dl>
        <button>Apply</button>
    </form>
</c:if>
<h4>${requestScope.messageEdit}</h4>

</body>
</html>
