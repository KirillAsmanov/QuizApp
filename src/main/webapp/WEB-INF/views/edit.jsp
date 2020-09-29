<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty quiz.name}">
        <title>Создание теста</title>
    </c:if>
    <c:if test="${!empty quiz.name}">
        <title>Редактирование теста</title>
    </c:if>
</head>
<body>
<c:if test="${empty quiz.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty quiz.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <label for="name">Название</label>
    <input type="text" name="name" id="name">
    <label for="questionCount">Укажите количество вопросов</label>
    <input type="text" name="questionCount" id="questionCount">

    <input type="submit" value="Продолжить">
</form>
<c:url value="/edit/${quiz.id}/new" var="var1"/>
<a href="${var1}">info</a>
</body>
</html>