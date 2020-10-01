<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Тесты</title>
    </head>
    <body>
        <h2>Доступные тесты:</h2>

        <table>
            <tr>
                <th>Название:</th>
                <th>Вопросов:</th>
                <th>Дата:</th>
                <th>Действие:</th>
            </tr>
            <c:forEach var="quiz" items="${quizList}">
            <tr>
                <td>${quiz.name}</td>
                <td>${quiz.questionsMap.size()}</td>
                <td><fmt:formatDate value='${quiz.createDate}' type='date' pattern='yyyy-MM-dd'/></td>
                <td>
                    <a href="/edit/${quiz.id}">edit</a>
                    <a href="/delete/${quiz.id}">delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>

        <c:url value="/add" var="add"/>
        <a href="${add}">Добавить новый</a>
    </body>
</html>
