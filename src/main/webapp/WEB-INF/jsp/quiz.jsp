<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h2>Quiz</h2>
<form action="/quiz" method="post">
    <c:forEach var="question" items="${questions}" varStatus="status">
        <p>${question[0]}</p>
        <c:forEach var="choice" items="${question}" begin="1">
            <c:set var="choiceText" value="${fn:split(choice, ':')[1]}" />
            <input type="radio" name="q${status.index}" value="${choice}"> ${choiceText}<br>
        </c:forEach>
    </c:forEach>
    <input type="submit" value="Submit">
</form>
</body>
</html>
