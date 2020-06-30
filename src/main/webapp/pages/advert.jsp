<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert</title>z
</head>
<body>


<h3>Имя владельца</h3>
${requestScope.user.name}
<h3>Фамилия владельца</h3>
${requestScope.user.lastName}
<h3>Телефон владельца</h3>
${requestScope.user.phone}
<h3>Модель автомобиля</h3>
${requestScope.advert.modelCar}
<h3>Цвет автомобиля</h3>
${requestScope.advert.colorCar}
<h3>Год автомобиля</h3>
${requestScope.advert.yearCar}
<h3>Цена автомобиля</h3>
${requestScope.advert.priceCar}
<h3>Описание</h3>
${requestScope.advert.specificationAdvert}
<h3>Дата регистрации</h3>
${requestScope.advert.dateAdvert}

<c:if test="${sessionScope.checkAuth}">

    <h3>Сообщения</h3>
<ul>
    <c:forEach items="${requestScope.advert.message}" var="item">
        <li>${item.nameUser} ${item.date} ${item.body}</li>
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

