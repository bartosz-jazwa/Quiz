<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jazwa
  Date: 2019-03-24
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<header>Questions</header>


<form action="question" method="post">
    <c:forEach var="question" items="${questions}">
    Pytanie: ${question.getContent()}<br>

    <input type="radio" id="A" name=${question.getId()} value="A"> ${question.getAnswer1()}<br>
    <input type="radio" id="B" name=${question.getId()} value="B"> ${question.getAnswer2()}<br>
    <input type="radio" id="C" name=${question.getId()} value="C"> ${question.getAnswer3()}<br>


        </c:forEach>
    <input type="submit" value="Dalej"><br>
    </form>


</body>
</html>
