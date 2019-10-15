
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Shop</title>
    <h2>New Shop</h2>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Go back</a>
<form method="post">
<label>id
    <br>
    <input type="text" name="idShop"></br>
</label>
<label>Name
    <br>
    <input type="text" name="name"></br>
</label>
<label>Address
    <br>
    <input type="text" name="address"></br>
</label>
<label>Phone number
    <br>
    <input type="text" name="phone"></br>
</label>
<label>
    <br>
    <button type="submit"> Add </button>
</label>
</form>
</body>
</html>
