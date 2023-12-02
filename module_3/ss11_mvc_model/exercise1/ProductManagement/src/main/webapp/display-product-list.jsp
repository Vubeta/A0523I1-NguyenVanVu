<%--
  Created by IntelliJ IDEA.
  User: vubet
  Date: 11/29/2023
  Time: 2:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Hiển thị danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <style>
        .container-customize {
            display: flex;
            margin: 1%;
        }
        .container-customize form {
            margin: 0;
            padding: 0;
        }
        .left-column {
            width: 50%;
            margin: 0;
            padding: 0;
        }
        .center-column {
            width: 20%;
        }
        .right-column {
            width: 30%;
            display: flex;
            justify-content: end;
        }
    </style>
</head>
<body>
<div class="container-customize">
    <form action="/product-servlet?action=search" method="post" class="input-group left-column">
        <input type="text" class="form-control" placeholder="Enter the product name here" name="productName">
        <button class="btn btn-outline-secondary" type="submit">Search</button>
    </form>
    <div class="center-column"></div>
    <div class="right-column">
        <a class="btn btn-success" href="/product-servlet?action=create" role="button">
            <i class="fa-regular fa-square-plus"></i> Create new product
        </a>
    </div>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Product Id</th>
        <th scope="col">Product Name</th>
        <th scope="col">Product Price</th>
        <th scope="col">Producer</th>
        <th scope="col">Change</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product" varStatus="loopProduct">
        <tr>
            <td><c:out value="${product.getProductId()}"/></td>
            <td><c:out value="${product.getProductName()}"/></td>
            <td><fmt:formatNumber value="${product.getProductPrice()}" type="number"/></td>
            <td><c:out value="${product.getProducer()}"/></td>
            <td>
                <a href="<c:out value='/product-servlet?action=detail&productId=${product.getProductId()}'/>">Show Details</a>
                /
                <a href="<c:out value='/product-servlet?action=update&productId=${product.getProductId()}'/>">Update</a>
                /
                <a href="<c:out value='/product-servlet?action=remove&productId=${product.getProductId()}'/>">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
