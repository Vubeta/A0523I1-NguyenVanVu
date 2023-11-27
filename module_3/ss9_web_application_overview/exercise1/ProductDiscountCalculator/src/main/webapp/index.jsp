<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="Discount" method="post">
<label>Product Description:</label>
<input type="text" name="productDescription" required><br>

<label>List Price:</label>
<input type="text" name="listPrice" required><br>

<label>Discount Percent:</label>
<input type="text" name="discountPercent" required><br>

<button type="submit">Calculate Discount</button>
</form>
<h2>Discount Result</h2>
<p><strong>Product Description:</strong> ${productDescription}</p>
<p><strong>List Price:</strong> ${listPrice}</p>
<p><strong>Discount Percent:</strong> ${discountPercent}</p>
<p><strong>Discount Amount:</strong> ${discountAmount}</p>
<p><strong>Discounted Priced:</strong> ${discountedPriced}</p>
</body>
</body>
</html>