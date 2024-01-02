<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Convert USD to VNĐ</h1>
<form action="/conversion" method="post">
    <label for="usdAmount">Usd Amount</label>
    <input type="text" id="usdAmount" name="usdAmount" pattern="^-?\d*\.?\d+$">
    <label for="exchangeRate">Exchange Rate</label>
    <input type="text" id="exchangeRate" name="exchangeRate" pattern="^-?\d*\.?\d+$">
    <button type="submit">Convert</button>
</form>
</body>
</html>
