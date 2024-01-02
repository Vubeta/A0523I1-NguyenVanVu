<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/find" method="post">
    <label for="engInput">English</label>
    <input type="text" name="engInput" id="engInput" required>
    <button type="submit">Find</button>
    <c:if test="${result ne null}">
        <p><c:out value="${result}"/></p>
    </c:if>
</form>
</body>
</html>
