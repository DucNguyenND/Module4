<%--
  Created by IntelliJ IDEA.
  User: DucNguyen
  Date: 7/14/2022
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/caculator" method="post">
    <input type="number" name="type1">
    <input type="number" name="type2">
    <button type="submit" name="mt" value="cong">Adđition(+)</button>
    <button type="submit" name="mt" value="tru">Subtraction(-)</button>
    <button type="submit" name="mt" value="nhan">Multiplication(X)</button>
    <button type="submit" name="mt" value="chia">Division(/)</button>
</form>
<h2>${ketqua}</h2>
</body>
</html>
