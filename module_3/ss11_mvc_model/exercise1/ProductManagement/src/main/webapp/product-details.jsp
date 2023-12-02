<%--
  Created by IntelliJ IDEA.
  User: vubet
  Date: 12/02/2023
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Show Product Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        .selected-customize {
            display: flex;
            align-items: center;
        }

        .selected-customize form {
            margin: 0 10px 0 0;
        }
    </style>
</head>
<body>
<h1>Show product details with id <c:out value="${productId}"/></h1>
<%--table information--%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Product Id</th>
        <th scope="col">Product Name</th>
        <th scope="col">Product Price</th>
        <th scope="col">Product Detail</th>
        <th scope="col">Producer</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${productId}"/></td>
        <td><c:out value="${productName}"/></td>
        <td><fmt:formatNumber value="${productPrice}" type="number"/></td>
        <td><c:out value="${productDetail}"/></td>
        <td><c:out value="${producer}"/></td>
    </tr>
    </tbody>
</table>
<a class="btn btn-secondary" href="/product-servlet" role="button">Back to list product</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
