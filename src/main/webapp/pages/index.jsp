<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Hello${sessionScope.currentUser.name}!
        It's Cars Catalog ver.1</h1>


    <ul>
        <c:forEach items="{requestScope.allAdverts}" var="item">
            <li>
                <form type="text" action="/messageServlet" method="get">
                        ${item}
<%--                    Как передать айди объявления в сервлет?--%>
                    <input type="text" name="${item.id}">
                    <button>Select</button>
                </form>
            </li>
        </c:forEach>
    </ul>

    <c:if test="${!sessionScope.checkAuth}">
        <a href="/reg">Registration |</a>
        <a href="/auth">Authorisation |</a>
    </c:if>

    <c:if test="${sessionScope.checkAuth}">
        <a href="/ads">Ads |</a>
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
