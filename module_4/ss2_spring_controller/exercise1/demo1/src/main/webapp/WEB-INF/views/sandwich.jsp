<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="/save" method="get">
    <c:forEach items="${arr}" var="s">
        <input type="checkbox" name="condiment" value="${s}"><c:out value="${s}"/>
    </c:forEach>
    <hr>
    <button type="submit">Save</button>
</form>
</body>
</html>
