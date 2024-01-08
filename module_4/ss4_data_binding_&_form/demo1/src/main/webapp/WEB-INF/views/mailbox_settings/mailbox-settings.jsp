<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Mail Box Settings</title>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/mailbox/updateSettings" modelAttribute="mailbox-settings">
    <label for="languages">Languages</label>
    <form:select path="languages" items="${languageList}" />
    <br>
    <label for="pageSize">Page Size: </label>
    <span>Show </span>
    <form:select path="pageSize" items="${pageSizeList}" />
    <span> emails per page</span>
    <br>
    <label for="spamFilter">Spam Filter: </label>
    <form:checkbox path="spamFilter" id="spamFilter" />
    <span>Enable spams filter</span>
    <br>
    <label for="signature">Signature</label>
    <form:input path="signature" />
    <br>
    <button type="submit" value="updateSettings">Update</button>
    <button>Cancel</button>
</form:form>
</body>
</html>
