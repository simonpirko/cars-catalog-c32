<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Hello${sessionScope.currentUser.name}!
        It's Cars Catalog ver.1</h1>


    <ul>
        <c:forEach items="${requestScope.advertList}" var="last">
            <li>${last}</li>
        </c:forEach>
    </ul>

    <c:if test="${!sessionScope.checkAuth}">
        <a href="/reg">Registration |</a>
        <a href="/auth">Authorisation |</a>
    </c:if>

    <c:if test="${sessionScope.checkAuth}">
        <a href="/addAdvert">Add Advert |</a>
        <a href="/pers">PersonalAccount |</a>
        <a href="/logout">Logout |</a>
    </c:if>


</head>
<body>

<p>Today: <c:out value="<%=new java.util.Date()%>"/></p>

<%--<ul style="list-style: decimal">--%>
<%--    <c:forEach items="${requestScope.adsList}" var="adsList">--%>
<%--        <li>${adsList}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

</body>

</html>
