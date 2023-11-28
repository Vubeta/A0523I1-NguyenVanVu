<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="Calculate" method="get">
    <label>First operand</label>
    <input type="number" name="firstOperand" required><br>

    <label>Operator</label>
    <select name="operator">
        <option value="addition" selected>Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select><br>

    <label>Second operand</label>
    <input type="number" name="secondOperand" required><br>

    <button type="submit">Calculate</button>
</form>
</body>
</html>