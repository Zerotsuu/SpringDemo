<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Welcome!, ${userSession.username}</h2>  <br>
<a href="quiz">${hasTakenQuiz ? 'Retake Quiz': 'Take Quiz'}</a> <br>
<a href="grade">View Grades</a> <br>
<a href="logout">Logout</a>

</body>
</html>
