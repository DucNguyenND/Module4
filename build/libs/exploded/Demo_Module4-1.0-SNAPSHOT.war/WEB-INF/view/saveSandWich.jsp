<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DucNguyen
  Date: 7/14/2022
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Sandwich</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="/sandwich" method="post">
<input type="checkbox" name="name" value="Lettuce"><label> Lettuce</label>
<input type="checkbox" name="name" value="Tomato"><label> Tomato</label>
<input type="checkbox" name="name" value="Mustard"><label> Mustard</label>
<input type="checkbox" name="name" value="Sprouts"><label> Sprouts</label>
<button type="submit">Submit</button>
</form>
<c:forEach var="a" items="${condition}">
    <h3>${a} </h3>
</c:forEach>
</body>
</html>
