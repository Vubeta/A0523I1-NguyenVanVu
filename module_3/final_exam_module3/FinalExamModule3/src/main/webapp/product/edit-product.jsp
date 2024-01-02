<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Edit customer</title>
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
    <h1>Update information for customer</h1>
    <%--table information--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
            <th scope="col">Birth date</th>
            <th scope="col">Gender</th>
            <th scope="col">Id card</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><c:out value="${customerCount}"/></td>
            <td><c:out value="${String.format('KH-%04d',customer.customerId)}"/></td>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.customerType.customerTypeName}"/></td>
            <td><c:out value="${customer.customerBirth}"/></td>
            <td><c:out value="${customer.customerGender ? 'Nam' : 'Nữ'}"/></td>
            <td><c:out value="${customer.customerIdCard}"/></td>
            <td><c:out value="${customer.customerPhone}"/></td>
            <td><c:out value="${customer.customerEmail}"/></td>
            <td><c:out value="${customer.customerAddress}"/></td>
        </tr>
        </tbody>
    </table>

    <%--form update--%>
    <form action="/furama-servlet?action=edit-customer&customerId=${customer.customerId}" method="post">
        <%--Customer Name--%>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Customer Name</label>
            <input name="customerName" type="text" class="form-control" id="exampleFormControlInput1"
                   value="<c:out value='${customer.customerName}'/>">
        </div>
        <%--Customer Type--%>
        <div class="mb-3">
            <label for="exampleFormControlInput2" class="form-label">Customer Type</label>
            <select class="form-select" id="exampleFormControlInput2" name="customerType">
                <c:forEach items="${listCustomerType}" var="customerType" varStatus="loopCustomerType">
                    <option value="${customerType.customerTypeId}" ${customerType.customerTypeId eq customer.customerType.customerTypeId ? 'selected' : ''}>
                        <c:out value="${customerType.customerTypeName}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <%--Customer Birthday--%>
        <div class="mb-3">
            <label for="exampleFormControlInput3" class="form-label">Customer Birthday</label>
            <input name="customerBirth" type="text" class="form-control" id="exampleFormControlInput3"
                   value="<c:out value='${customer.customerBirth}'/>">
        </div>
        <%--Customer Gender --%>
        <select class="form-select" id="exampleFormControlInput4" name="customerGender">
            <option value="true" ${customer.customerGender eq true ? 'selected' : ''}>Nam</option>
            <option value="false" ${customer.customerGender ne true ? 'selected' : ''}>Nữ</option>
        </select>
        <%--Customer Id Card--%>
        <div class="mb-3">
            <label for="exampleFormControlInput5" class="form-label">Customer Id Card</label>
            <input name="customerIdCard" type="text" class="form-control" id="exampleFormControlInput5"
                   value="<c:out value='${customer.customerIdCard}'/>">
        </div>
        <%--Customer Phone--%>
        <div class="mb-3">
            <label for="exampleFormControlInput6" class="form-label">Customer Phone</label>
            <input name="customerPhone" type="text" class="form-control" id="exampleFormControlInput6"
                   value="<c:out value='${customer.customerPhone}'/>">
        </div>
        <%--Customer Email--%>
        <div class="mb-3">
            <label for="exampleFormControlInput7" class="form-label">Customer Email</label>
            <input name="customerEmail" type="text" class="form-control" id="exampleFormControlInput7"
                   value="<c:out value='${customer.customerEmail}'/>">
        </div>
        <%--Customer Address--%>
        <div class="mb-3">
            <label for="exampleFormControlInput8" class="form-label">Customer Address</label>
            <input name="customerAddress" type="text" class="form-control" id="exampleFormControlInput8"
                   value="<c:out value='${customer.customerAddress}'/>">
        </div>
        <%--Customer Submit--%>
        <div class="d-flex align-items-center">
            <button type="submit" class="btn btn-primary m-0 me-" name="customerId" value="${customer.customerId}">Update customer</button>
            <a class="btn btn-secondary ms-1p" href="/furama-servlet" role="button">Back to list product</a>
        </div>
    </form>
</div>
<script src="../bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
</body>
</html>
