<%--
  Created by IntelliJ IDEA.
  User: vubet
  Date: 11/30/2023
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Product</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <style>
    .selected-customize {
      display: flex;
      align-items: center;
    }

    .selected-customize button {
      margin: 0 10px 0 0;
    }
  </style>
</head>
<body>
<div style="width: 75%; margin: 5%">
  <h1>Enter information below to create a new product</h1>
  <form action="/product-servlet?action=create" method="post">
    <%--Product Id--%>
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">Product Id</label>
      <input name="productId" type="text" class="form-control" id="exampleFormControlInput1" placeholder="PXXX with XXX is number">
    </div>
    <%--Product Name--%>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">Product Name</label>
      <input name="productName" type="text" class="form-control" id="exampleFormControlInput2">
    </div>
    <%--Product Price--%>
    <div class="mb-3">
      <label for="exampleFormControlInput3" class="form-label">Product Price</label>
      <input name="productPrice" type="number" class="form-control" id="exampleFormControlInput3">
    </div>
    <%--Product Detail--%>
    <div class="mb-3">
      <label for="exampleFormControlTextarea4" class="form-label">Product Detail</label>
      <textarea name="productDetail" class="form-control" id="exampleFormControlTextarea4" rows="3"></textarea>
    </div>
    <%--Product Producer--%>
    <div class="mb-3">
      <label for="exampleFormControlInput5" class="form-label">Product Producer</label>
      <input name="producer" type="text" class="form-control" id="exampleFormControlInput5">
    </div>
      <div class="selected-customize">
        <button type="submit" class="btn btn-success">Create product</button>
        <a class="btn btn-secondary" href="/product-servlet" role="button">Back to list product</a>
    </div>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
