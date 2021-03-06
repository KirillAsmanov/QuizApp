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
    <label for="description">Введите описание:</label>
    <input type="text" name="description" id="description">
    <table>
    <c:forEach var="question" items="${questionList}">
        <tr>
            <td>${question.text}</td>
            <td>
                <a href="/edit/${question.id}">edit</a>
                <a href="/delete/${quiz.id}/${question.id}">delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Продолжить">

</form>
</body>
</html>