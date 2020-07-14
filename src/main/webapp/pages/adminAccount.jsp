<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<c:if test="${sessionScope.adminBoolean}">
    <h2>Что делаем</h2>

<a href="/changeProfile">Operations with user</a>
<a href="/changeAdvertisement">Operations with advert</a>
<a href="/">Homepage</a>
<a href="/logout">Logout</a>
</body>
</c:if>
</html>
