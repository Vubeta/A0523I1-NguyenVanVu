<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="../bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<style>
    .m-1p {
        margin: 1%;
    }

    .table tr {
        vertical-align: middle;
    }
</style>
<body>

<div class="d-flex m-1p">
    <form action="/furama-servlet" method="get" class="input-group m-0 p-0 w-50">
        <input type="text" class="form-control" placeholder="Enter the customer name here" name="customerName">
        <button class="btn btn-outline-secondary" type="submit" name="action" value="find-customer">Search</button>
    </form>
    <div class="w-25"></div>
    <div class="w-25 d-flex justify-content-end">
        <a class="btn btn-success" href="/furama-servlet?action=add-customer" role="button">
            <i class="fa-regular fa-square-plus"></i> Create new customer
        </a>
    </div>
</div>

<%--START TABLE CUSTOMER--%>
<table class="table table-hover">
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
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer" varStatus="loopCustomer">
        <tr>
            <td><c:out value="${loopCustomer.count}"/></td>
            <td><c:out value="${String.format('KH-%04d',customer.customerId)}"/></td>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.customerType.customerTypeName}"/></td>
            <td><c:out value="${customer.customerBirth}"/></td>
            <td><c:out value="${customer.customerGender ? 'Nam' : 'Nữ'}"/></td>
            <td><c:out value="${customer.customerIdCard}"/></td>
            <td><c:out value="${customer.customerPhone}"/></td>
            <td><c:out value="${customer.customerEmail}"/></td>
            <td><c:out value="${customer.customerAddress}"/></td>
            <td>
                <a class="btn btn-primary" href="/furama-servlet?action=edit-customer&customerId=${customer.customerId}&customerCount=${loopCustomer.count}"
                   role="button">Edit</a>
                <a class="btn btn-danger" onclick="sendInfo('${loopCustomer.count}','${customer.customerId}','${customer.customerName}')"
                   data-bs-toggle="modal" data-bs-target="#exampleModal" role="button">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--FINISH TABLE CUSTOMER--%>

<%--START MODAL DELETE CUSTOMER--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete customer:</p>
                <p id="confirm-delete-1"></p>
            </div>
            <form action="/furama-servlet?action=delete-customer" method="post">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger" name="customerId" id="confirm-delete-2">Delete customer</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--FINISH MODAL DELETE CUSTOMER--%>

<script src="../bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
<script>
  function sendInfo(count,id,name){
    document.getElementById("confirm-delete-1").innerText = count + ". " + name;
    document.getElementById("confirm-delete-2").value = id;
  }
</script>
</body>
</html>
