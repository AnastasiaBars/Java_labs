
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Go back</a>
<div align="center">
    <form method="post">
        <label>id
            <br>
            <input type="text" name="idShop" value="0"></br>
        </label>
        <label>Name
            <br>
            <input type="text" name="name" value="${shop.name}"></br>
        </label>
        <label>Address
            <br>
            <input type="text" name="address" value="${shop.address}"></br>
        </label>
        <label>Phone number
            <br>
            <input type="text" name="phone" value="${shop.phone}"></br>
            <br>
        </label>
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>
