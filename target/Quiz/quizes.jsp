<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jazwa
  Date: 2019-03-24
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quizes</title>
</head>
<body>
<section>
    <header>Quiz</header>
    <c:forEach var="quiz" items="${quizzes}">
    <article>
            <a href="/question?id=${quiz.getId()}">${quiz.getTitle()}</a>
    </article>
    </c:forEach>

</body>
</html>
