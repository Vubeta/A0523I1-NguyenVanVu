<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="get">
    <input type="text" name="firstNum" pattern="^\d*\.?\d+$" required>
    <input type="text" name="secondNum" pattern="^\d*\.?\d+$" required>
    <br><br>
    <button type="submit" name="calculation" value="add">Addition(+)</button>
    <button type="submit" name="calculation" value="sub">Subtraction(-)</button>
    <button type="submit" name="calculation" value="mul">Multilication(X)</button>
    <button type="submit" name="calculation" value="div">Division(/)</button>
</form>
<br><br>
<p><c:out value="${result}"/></p>
</body>
</html>
