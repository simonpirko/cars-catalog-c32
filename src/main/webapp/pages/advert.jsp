<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert</title>
</head>
<body>


<h3>Имя владельца</h3>
${requestScope.name}
<h3>Фамилия владельца</h3>
${requestScope.lastName}
<h3>Телефон владельца</h3>
${requestScope.phone}
<h3>Модель автомобиля</h3>
${requestScope.model}
<h3>Цвет автомобиля</h3>
${requestScope.color}
<h3>Год автомобиля</h3>
${requestScope.year}
<h3>Цена автомобиля</h3>
${requestScope.price}


<c:if test="${sessionScope.checkAuth}">

    <h3>Сообщения</h3>
<ul>
    <c:forEach items="${requestScope.messages}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>



<h3>Add message</h3>
<form name="addMessage" action="/MessageServlet?id=${requestScope.id}" method="post">
    <input type="text" name="addMessage" placeholder="Add message">
    <button>Submit</button>
</form>
</c:if>

<a href="/">Go to main page</a>

</body>
</html>

