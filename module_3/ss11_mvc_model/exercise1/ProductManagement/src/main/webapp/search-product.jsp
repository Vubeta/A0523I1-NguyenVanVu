<%--
  Created by IntelliJ IDEA.
  User: vubet
  Date: 12/02/2023
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Search Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <h1>Search results for product name: <c:out value="${productName}"/></h1>
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
                    <a href="<c:out value='/product-servlet?action=detail&productId=${product.getProductId()}'/>">Show
                        Details</a>
                    /
                    <a href="<c:out value='/product-servlet?action=update&productId=${product.getProductId()}'/>">Update</a>
                    /
                    <a href="<c:out value='/product-servlet?action=remove&productId=${product.getProductId()}'/>">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-secondary" href="/product-servlet" role="button">Back to list product</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
