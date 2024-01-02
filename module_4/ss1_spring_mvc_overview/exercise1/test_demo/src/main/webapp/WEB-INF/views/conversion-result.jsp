<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Conversion Result</title>
</head>
<body>
<h1>Conversion Result</h1>
<p>USD Amount: <c:out value="${result.usdAmount}"/></p>
<p>VND Amount: <c:out value="${result.vndAmount}"/></p>
<p>Exchange Rate: <c:out value="${result.exchangeRate}"/></p>
</body>
</html>
