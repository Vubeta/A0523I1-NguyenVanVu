<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Sandwich</title>
</head>
<body>
<c:forEach items="${list}" var="arr" varStatus="loop">
    <p><c:out value="${loop.count}. "/>
    <c:forEach items="${arr}" var="s">
        <c:out value="${s}"/>
    </c:forEach>
    </p>
</c:forEach>
<a href="/sandwich">Quay lại</a>
</body>
</html>
