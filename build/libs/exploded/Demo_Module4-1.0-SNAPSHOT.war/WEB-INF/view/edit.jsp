<%--
  Created by IntelliJ IDEA.
  User: DucNguyen
  Date: 7/13/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="post">
    <input type="text" value="${product.id}" readonly name="id">
    <input type="text" value="${product.name}" name="name">
    <input type="text" value="${product.price}" name="price">
    <input type="text" value="${product.img}" name="img">
    <button type="submit">Submit</button>

</form>
</body>
</html>
