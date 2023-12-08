<%--
  Created by IntelliJ IDEA.
  User: vubet
  Date: 12/06/2023
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
<h1>User Management</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${usersListByCountry}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getName()}"/></td>
                <td><c:out value="${user.getEmail()}"/></td>
                <td><c:out value="${user.getCountry()}"/></td>
                <td>
                    <a href="<c:out value='/users?action=edit&id=${user.id}'/>">Edit</a>
                    <a href="<c:out value='/users?action=delete&id=${user.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
