<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grades</title>
</head>
<body>
<h2>Grades for ${username}</h2>
<p>Your grade: ${grade}</p>
<h3>All Grades:</h3>
<table border="1">
    <tr>
        <th>Username</th>
        <th>Grade</th>
    </tr>
    <c:forEach var="entry" items="${allGrades}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>
<a href="/">Back to Home</a>
</body>
</html>
