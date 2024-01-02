<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Create Customer</title>
    <link rel="stylesheet" href="../bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<style>
  .m-1p {
    margin: 1%;
  }

  .ms-1p {
    margin-left: 1%;
  }
</style>
<body>
<div class="m-1p">
  <h1>Create new customer</h1>

  <%--form create--%>
  <form action="/furama-servlet?action=add-customer" method="post">
    <%--Customer Name--%>
    <div class="mb-3">
      <label for="exampleFormControlInput1" class="form-label">Customer Name</label>
      <input name="customerName" type="text" class="form-control" id="exampleFormControlInput1">
    </div>
    <%--Customer Type--%>
    <div class="mb-3">
      <label for="exampleFormControlInput2" class="form-label">Customer Type</label>
      <select class="form-select" id="exampleFormControlInput2" name="customerType">
        <c:forEach items="${listCustomerType}" var="customerType" varStatus="loopCustomerType">
          <option value="${customerType.customerTypeId}">
            <c:out value="${customerType.customerTypeName}"/>
          </option>
        </c:forEach>
      </select>
    </div>
    <%--Customer Birthday--%>
    <div class="mb-3">
      <label for="exampleFormControlInput3" class="form-label">Customer Birthday</label>
      <input name="customerBirth" type="date" class="form-control" id="exampleFormControlInput3" min="1900-01-01" max="2030-12-31">
    </div>
    <%--Customer Gender --%>
    <select class="form-select" id="exampleFormControlInput4" name="customerGender">
      <option value="true">Nam</option>
      <option value="false">Nữ</option>
    </select>
    <%--Customer Id Card--%>
    <div class="mb-3">
      <label for="exampleFormControlInput5" class="form-label">Customer Id Card</label>
      <input name="customerIdCard" type="text" class="form-control" id="exampleFormControlInput5" pattern="^(\d{9}|\d{12})$">
    </div>
    <%--Customer Phone--%>
    <div class="mb-3">
      <label for="exampleFormControlInput6" class="form-label">Customer Phone</label>
      <input name="customerPhone" type="text" class="form-control" id="exampleFormControlInput6" pattern="^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$">
    </div>
    <%--Customer Email--%>
    <div class="mb-3">
      <label for="exampleFormControlInput7" class="form-label">Customer Email</label>
      <input name="customerEmail" type="text" class="form-control" id="exampleFormControlInput7" pattern="^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\.+[a-zA-Z0-9]+$">
    </div>
    <%--Customer Address--%>
    <div class="mb-3">
      <label for="exampleFormControlInput8" class="form-label">Customer Address</label>
      <input name="customerAddress" type="text" class="form-control" id="exampleFormControlInput8">
    </div>
    <%--Customer Submit--%>
    <div class="d-flex align-items-center">
      <button type="submit" class="btn btn-primary m-0 me-">Create customer</button>
      <a class="btn btn-secondary ms-1p" href="/furama-servlet" role="button">Back to list product</a>
    </div>
  </form>
</div>
<script src="../bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
</body>
</html>
